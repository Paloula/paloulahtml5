package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceDeleteElement {
	
	private Document xmlDocument = null;
	private Element deleteElement = null;
	private ContentAttributes contentAttributes = null;
	private String deleteElementTagName;
	
	
	public SequenceDeleteElement(Document xmlDocument, ContentAttributes contentAttributes, String deleteElementId) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionStringIsNullOrEmpty(deleteElementId, "Delete element id");		
		
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
		this.setDeleteElementById(deleteElementId);
		this.setTagName();
	}	
	
	public SequenceDeleteElement(Document xmlDocument, ContentAttributes contentAttributes, Element deleteElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(deleteElement, "Delete Element");
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(xmlDocument, deleteElement);
		
		this.xmlDocument = xmlDocument;		
		this.contentAttributes = contentAttributes;
		this.setSetDeleteElementByElement(deleteElement);
		this.setTagName();
	}
	
	private void setDeleteElementById(String deleteElementId) throws PaloulaXmlException {
		String xpathTargetElement = "//*[@" + this.contentAttributes.getIdAttributeName() + "='" + deleteElementId + "']";
		Element deleteElement = JDomXPath.getFirstElement(xpathTargetElement, this.xmlDocument);		
		SequenceCheckExceptions.checkExceptionElementNull(deleteElement, this.contentAttributes.getIdAttributeName(), deleteElementId);
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(deleteElement, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, deleteElement);
		
		this.deleteElement = deleteElement;		
	}
	
	private void setSetDeleteElementByElement(Element deleteElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(deleteElement, this.contentAttributes.getIdAttributeName(), "");
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(deleteElement, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, deleteElement);
		
		this.deleteElement = deleteElement;		
	}	
	
	private void setTagName() {
		this.deleteElementTagName = this.deleteElement.getName();
	}
	
	public String getTagName() {
		return this.deleteElementTagName;
	}
	
	public Element getParentElement() {
		return this.deleteElement.getParentElement();
	}
	
	public Element getDeleteElement() {
		return this.deleteElement;
	}

	public Integer getPosition() {
		String attributePosition = this.deleteElement.getAttributeValue(this.contentAttributes.getPositionAttributeName());
		Integer position = Integer.parseInt(attributePosition);
		
		return position;
	}
}
