package de.paloula.xsl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.sun.istack.internal.NotNull;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;

public class ConcatenateXsl {

	private ConcatenateXsl() {
	}

	public static Document getConcatenateXsl(List<Document> xslDocuments) {
		Document concatenatedXsl = XslUtilities.getEmptyXSLDocument();
		Element concatenatedXslRoot = concatenatedXsl.getRootElement();

		for (Document xslDocument : xslDocuments) {
			ConcatenateXsl.addTemplates(xslDocument, concatenatedXslRoot);
		}

		return concatenatedXsl;
	}

	public static Document getConcatenateXsl(@NotNull Path xslFilePath) throws JDOMException, IOException, PaloulaXslException {
		Document concatenatedXsl = ConcatenateXsl.getConcatenateXsl(xslFilePath, null);

		return concatenatedXsl;
	}

	public static Document getConcatenateXsl(@NotNull Path xslFilePath, List<Path> additionalXslFilePaths) throws JDOMException, IOException, PaloulaXslException {
		ConcatenateXslUtilities.checkExceptionPathIsNull(xslFilePath);
		ConcatenateXslUtilities.checkExceptionXSLFileExists(xslFilePath.toFile(), xslFilePath.toString());
		Document startXslDocument = JDomDocument.getJDomDocument(xslFilePath);

		List<Path> includes = new ArrayList<Path>();
		includes.add(xslFilePath);

		ConcatenateXsl.addIncludePath(xslFilePath, startXslDocument, includes);
		ConcatenateXslUtilities.warningIfNecessaryDublicateIncludes(includes);
		ConcatenateXsl.addAditionalXSLFilePath(includes, additionalXslFilePaths);

		Set<Path> includesSet = new HashSet<Path>(includes);
		Document concatenatedXsl = ConcatenateXsl.concatenateXsl(includesSet);
		System.out.println(JDomDocument.getStringFromDocumentExpand(concatenatedXsl));

		return concatenatedXsl;
	}

	private static Document concatenateXsl(Set<Path> includesSet) throws JDOMException, IOException {
		Document concatenatedXsl = XslUtilities.getEmptyXSLDocument();
		Element concatenatedXslRoot = concatenatedXsl.getRootElement();

		for (Path xlsPath : includesSet) {
			Document xslDocument = JDomDocument.getJDomDocument(xlsPath);
			ConcatenateXsl.addTemplates(xslDocument, concatenatedXslRoot);
		}

		return concatenatedXsl;
	}

	private static void addTemplates(Document xslDocument, Element concatenatedXslRoot) {
		List<Element> xslTemplates = JDomXPath.getListXsl(".//xsl:template", xslDocument);

		for (Element xslTemplate : xslTemplates) {
			Element templateToAdd = xslTemplate.clone();
			concatenatedXslRoot.addContent(templateToAdd);
		}
	}

	private static void addIncludePath(Path xslFilePath, Document xslDocument, List<Path> includes) throws JDOMException, IOException, PaloulaXslException {
		ConcatenateXslUtilities.checkExceptionXslDocumentIsNull(xslDocument, xslFilePath);

		Path xslDirectoryPath = xslFilePath.getParent();
		Document includeXslDocument;
		String xPathIncludes = "*/xsl:include";
		List<Element> includeElements = JDomXPath.getListXsl(xPathIncludes, xslDocument);

		for (Element includeElement : includeElements) {
			String includeHref = includeElement.getAttributeValue("href");
			includeHref = ConcatenateXslUtilities.getCleanLeadingSlash(includeHref);

			ConcatenateXslUtilities.checkExceptionHrefIsNull(includeHref, xslDocument, xslFilePath);
			ConcatenateXslUtilities.checkExceptionPathIsAbsolute(includeHref);

			if (includeHref.contains("../")) {
				xslDirectoryPath = ConcatenateXslUtilities.getUpDirectory(includeHref, xslDirectoryPath);
				includeHref = includeHref.replaceAll("../", "");
			} else {
				includeHref = includeHref.replace("./", "");
			}

			Path includePath = xslDirectoryPath.resolve(includeHref);
			includePath = includePath.normalize();
			ConcatenateXslUtilities.checkExceptionXSLFileExists(includePath.toFile(), includePath.toString());
			includeXslDocument = JDomDocument.getJDomDocument(includePath);
			includes.add(includePath);

			ConcatenateXsl.addIncludePath(includePath, includeXslDocument, includes);
		}
	}

	private static void addAditionalXSLFilePath(List<Path> includes, List<Path> additionalXslFilePaths) throws PaloulaXslException {
		if (additionalXslFilePaths != null) {
			
			for (Path additionalXslFilePath : additionalXslFilePaths) {
				ConcatenateXslUtilities.checkExceptionXSLFileExists(additionalXslFilePath.toFile(), additionalXslFilePath.toString());
				includes.add(additionalXslFilePath);
			}
		}
	}
}
