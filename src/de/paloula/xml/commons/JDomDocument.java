package de.paloula.xml.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.validator.routines.UrlValidator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import de.paloula.xml.sequence.SequenceCheckExceptions;


public class JDomDocument {

	private JDomDocument() {		
	}
	
	public static Document getJDomDocument(String filePath) throws JDOMException, IOException {
		UrlValidator urlValidator = new UrlValidator();			
		Document document = null;
	    
		if (urlValidator.isValid(filePath)) {
	    	document = JDomDocument.getJDomDocumentFromUrl(filePath);
	    } else {
	    	document = JDomDocument.getJDomDocumentFromPath(filePath);
	    }			
		
		return document;
	}	
	
	public static Document getJDomDocument(Path filePath) throws JDOMException, IOException {
	    Document document = JDomDocument.getJDomDocumentFromPath(filePath);
		
		return document;
	}	

	private static Document getJDomDocumentFromPath(String filePath) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream jdomInputStream = new FileInputStream(filePath);		
		Document document = saxBuilder.build(jdomInputStream);
		
		return document;		
	}	

	private static Document getJDomDocumentFromUrl(String fileUrl) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(fileUrl);
		
		return document;			
	}
	
	private static Document getJDomDocumentFromPath(Path filePath) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream jdomInputStream = Files.newInputStream(filePath);		
		Document document = saxBuilder.build(jdomInputStream);
		
		return document;		
	}
	
	public static void writeJDomDocument(Document documentToWrite, String filePath) throws FileNotFoundException, IOException {
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        xmlOutputter.output(documentToWrite, new FileOutputStream(filePath));
	}
		
	public static String getStringFromDocumentExpand(Document document) {
		XMLOutputter xmlOutputter = new XMLOutputter();	   
		Format format = Format.getPrettyFormat();
	    format.setOmitDeclaration(true);
	    format.setExpandEmptyElements(true);
	    
	    format.setEncoding("UTF-8");
	    xmlOutputter.setFormat(format);				
		String documentString = xmlOutputter.outputString(document);

		return documentString;
	}
	
	public static String getStringFromDocumentNotExpand(Document document) {
		XMLOutputter xmlOutputter = new XMLOutputter();	   
		Format format = Format.getPrettyFormat();
	    format.setExpandEmptyElements(false);
	    
	    format.setEncoding("UTF-8");
	    format.setOmitDeclaration(true);
	   
	    xmlOutputter.setFormat(format);				
		String documentString = xmlOutputter.outputString(document);

		return documentString;
	}	
	
	public static String getStringFromElementExpand(Element element) {
		XMLOutputter xmlOutputter = new XMLOutputter();	   
		Format format = Format.getPrettyFormat();
	    format.setExpandEmptyElements(false);
	    
	    format.setEncoding("UTF-8");
	    format.setOmitDeclaration(true);
	   
	    xmlOutputter.setFormat(format);				
		String elementString = xmlOutputter.outputString(element);

		return elementString;
	}

	public static String getStringFromElementNotExpand(Element element) {
		XMLOutputter xmlOutputter = new XMLOutputter();	   
		Format format = Format.getPrettyFormat();
	    format.setExpandEmptyElements(false);
	    
	    format.setEncoding("UTF-8");
	    format.setOmitDeclaration(false);
	   
	    xmlOutputter.setFormat(format);				
		String elementString = xmlOutputter.outputString(element);

		return elementString;
	}

	public static Document getDocumentFromString(String xmlString) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		
		Document document = builder.build(new StringReader(xmlString));
		
		return document;
	}
	
	public static Document getEmptyDocument() {
		Element root = new Element("root");
	    Document newDocument = new Document(root);

	    return newDocument;
	}	
	
	public static Document getEmptyDocument(String rootElementName) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionStringIsNullOrEmpty(rootElementName, "root element name");
		Element root = new Element(rootElementName);
	    Document newDocument = new Document(root);

	    return newDocument;
	}		
}
