package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceParentElement {

	private Element parentElement = null;
	private Document xmlDocument = null;
	private ContentAttributes contentAttributeNames = new ContentAttributes();
	
	public SequenceParentElement(Document xmlDocument, ContentAttributes contentAttributeNames, Element parentElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(parentElement, "Parent element.");
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(xmlDocument, parentElement);
		this.xmlDocument = xmlDocument;
		this.contentAttributeNames = contentAttributeNames;
		this.parentElement = parentElement;
	}
	
	public SequenceParentElement(Document xmlDocument, ContentAttributes contentAttributeNames, String siblingElementId) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionStringIsNullOrEmpty(siblingElementId, "Sibling element id");
		this.xmlDocument = xmlDocument;
		this.contentAttributeNames = contentAttributeNames;
		this.setParentElementFromSibling(siblingElementId);
	}

	private void setParentElementFromSibling(String siblingElementId) throws PaloulaXmlException {
		String xpathTargetElement = "//*[@" + this.contentAttributeNames.getIdAttributeName() + "='" + siblingElementId + "']";
		Element childElement = JDomXPath.getFirstElement(xpathTargetElement, this.xmlDocument);
		SequenceCheckExceptions.checkExceptionElementNull(childElement, this.contentAttributeNames.getIdAttributeName(), siblingElementId);
		this.parentElement = childElement.getParentElement();
	}
	
	public Element getParentElement() {
		return this.parentElement;
	}	
}
