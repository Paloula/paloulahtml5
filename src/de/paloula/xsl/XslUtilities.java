package de.paloula.xsl;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;


public class XslUtilities {
	
	private XslUtilities() {		
	}
	
	public static Document getEmptyXSLDocument() {
		Namespace xslNS = Namespace.getNamespace("xsl", "http://www.w3.org/1999/XSL/Transform");
		Element styleSheetElement = new Element("stylesheet", xslNS);
		styleSheetElement.setAttribute("version", "1.0");
		Document xslDocument = new Document(styleSheetElement);
		
		return xslDocument;
	}
}
