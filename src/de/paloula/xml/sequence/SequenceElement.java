package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceElement {
	
	private Document xmlDocument = null;
	private Element element = null;
	private int startPosSequence = 1;
	private String siblingsXPath = null;
	private String elementId;
	private ContentAttributes contentAttributes = null;
	private SequenceParentElement sequenceParentElement;
	
	public SequenceElement(Document xmlDocument, ContentAttributes contentAttributes, boolean isTagNameSibling, String elementId) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionStringIsNullOrEmpty(elementId, "Sequence element id");		
		// Todo check contentAttributes = null;
		this.setXmlDocument(xmlDocument);
		this.setContentAttributes(contentAttributes);
		this.startPosSequence = contentAttributes.getStartPosSequence();
		
		this.setElementById(elementId); //======================	
		this.setXPath(isTagNameSibling);
		this.setParentFromId(elementId); //======================
	}	
	
	public SequenceElement(Document xmlDocument, ContentAttributes contentAttributes, boolean isTagNameSibling, Element element) throws PaloulaXmlException {
		this.setXmlDocument(xmlDocument);
		this.setContentAttributes(contentAttributes);
		this.startPosSequence = contentAttributes.getStartPosSequence();
		
		this.setElement(element);  //======================		
		this.setXPath(isTagNameSibling);
		this.setParentFromElement(element); //======================
	}	
	
	private void setXmlDocument(Document xmlDocument) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionDocumentIsNull(xmlDocument);
		this.xmlDocument = xmlDocument;
	}
	
	private void setContentAttributes(ContentAttributes contentAttributes) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionContentAttributesIsNull(contentAttributes);
		this.contentAttributes = contentAttributes;
	}
	
	private void setParentFromId(String elementId) throws PaloulaXmlException {
		this.sequenceParentElement = new SequenceParentElement(this.xmlDocument, this.contentAttributes, elementId);
	}
	
	private void setParentFromElement(Element element) throws PaloulaXmlException {
		this.sequenceParentElement = new SequenceParentElement(this.xmlDocument, this.contentAttributes, element.getParentElement());
	}
	
	private void setElementById(String elementId) throws PaloulaXmlException {
		String xpathTargetElement = "//*[@" + this.contentAttributes.getIdAttributeName() + "='" + elementId + "']";
		Element element = JDomXPath.getFirstElement(xpathTargetElement, this.xmlDocument);		
		this.setElement(element);	
	}
	
	private void setElement(Element element) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(element, this.contentAttributes.getIdAttributeName(), "");
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(element, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionSequenceElementPositionMissing(element, this.contentAttributes.getPositionAttributeName(), "");
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, element);
		
		this.elementId = element.getAttributeValue(this.contentAttributes.getIdAttributeName());
		this.element = element;		
	}	
	
	public Element getElement() {
		return this.element;
	}
	
	public String getElementId() {
		return this.elementId;
	}

	public Integer getBeforePosition() throws PaloulaXmlException {
		this.setSiblings();
		
		String attributePosition = this.element.getAttributeValue(this.contentAttributes.getPositionAttributeName());
		Integer position = Integer.parseInt(attributePosition);
		position = position - 1;
		
		if (position < this.startPosSequence) {
			position = this.startPosSequence;
		}
		
		return position;
	}
	
	public Integer getAfterPosition() throws PaloulaXmlException {
		this.setSiblings();
		
		String attributePosition = this.element.getAttributeValue(this.contentAttributes.getPositionAttributeName());
		Integer position = Integer.parseInt(attributePosition);		
		position = position + 1;		
		
		return position;
	}
	
	private void setSiblings() throws PaloulaXmlException {
		new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
	}	
	
	private void setXPath (boolean isTagNameSibling) {
		if (isTagNameSibling == true) {
			this.setXPathByTagNameInParent(this.element.getName());
		} else {
			this.setXPathAllSiblingsInParent();
		}
	}
	
	private void setXPathByTagNameInParent(String tagName) {
		 this.siblingsXPath = "./" + tagName; ;
	}
	
	private void setXPathAllSiblingsInParent() {
		 this.siblingsXPath = "./*";
	}	

}
