package de.paloula.xsl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;

public class ConcatenateXslUtilities {

	private ConcatenateXslUtilities() {
	}

	public static String getCleanLeadingSlash(String includeHref) {
		if (includeHref.charAt(0) == '/') {
			includeHref = includeHref.replace("/", "");
		}

		return includeHref;
	}

	public static Path getUpDirectory(String includeHref, Path xslDirectoryPath) {
		int upPath = StringUtils.countMatches(includeHref, "../");

		for (int i = 1; i <= upPath; i++) {
			xslDirectoryPath = xslDirectoryPath.getParent();
		}

		return xslDirectoryPath;
	}

	public static void warningIfNecessaryDublicateIncludes(List<Path> includes) {
		Set<Path> includesSet = new HashSet<Path>(includes);

		if (includesSet.size() < includes.size()) {
			System.out.println("+++Warning [com.paloula.xsl.ConcatenateXsl]: Duplicate xsl file declaration within includes! Please check includes");
		}
	}

	public static void checkExceptionPathIsNull(Path testPath) throws PaloulaXslException {
		if (testPath == null) {
			throw new PaloulaXslException(PaloulaXslError.PATH_IS_NULL, "com.paloula.xsl.ConcatenateXsl", " Path:" + testPath);
		}
	}

	public static void checkExceptionXslDocumentIsNull(Document xslDocument, Path xslFilePath) throws PaloulaXslException {
		if (xslDocument == null) {
			throw new PaloulaXslException(PaloulaXslError.HREF_NULL, "com.paloula.xsl.ConcatenateXsl", " Path:" + xslFilePath);
		}
	}

	public static void checkExceptionHrefIsNull(String includeHref, Document xslDocument, Path xslFilePath) throws PaloulaXslException {
		if (includeHref == null) {
			throw new PaloulaXslException(PaloulaXslError.HREF_NULL, "com.paloula.xsl.ConcatenateXsl", "Document: " + xslDocument + ", Path:" + xslFilePath);
		}
	}

	public static void checkExceptionPathIsAbsolute(String includeHref) throws PaloulaXslException {
		Path testPath = Paths.get(includeHref);

		if (testPath.isAbsolute()) {
			throw new PaloulaXslException(PaloulaXslError.PATH_IS_ABSOLUTE, "com.paloula.xsl.ConcatenateXsl", " Include href:" + includeHref);
		}
	}

	public static void checkExceptionXSLFileExists(File testXslFile, String includeHref) throws PaloulaXslException {
		if (testXslFile.exists() == false) {
			throw new PaloulaXslException(PaloulaXslError.XSL_FILE_DOESNOT_EXIST, "com.paloula.xsl.ConcatenateXsl", " Include href:" + includeHref);
		}
	}
}
