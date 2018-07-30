package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceInsertAt {

	private Document xmlDocument;
	private ContentAttributes contentAttributes = new ContentAttributes();
	private SequenceParentElement sequenceParentElement;
	private SequenceInsertElement sequenceInsertElement;
	private SequenceSiblings siblings;
	private String siblingsXPath = null;
	private int startPosSequence = 1;
	
	public SequenceInsertAt(Document xmlDocument, ContentAttributes contentAttributes) {
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
		this.startPosSequence = contentAttributes.getStartPosSequence();
	}
	
	public void insertAtWithinTagNameSiblings(String siblingElementId, Element insertElement, int targetPosition) throws PaloulaXmlException {
		this.setSequenceInsertElement(insertElement, targetPosition);
		this.setXPathByTagNameInParent(this.sequenceInsertElement.getTagName());
		this.insertAtFromSiblingElementId(siblingElementId, targetPosition);
	}
	
	public void insertAtWithinAllSiblings(String siblingElementId, Element insertElement, int targetPosition) throws PaloulaXmlException {
		this.setSequenceInsertElement(insertElement, targetPosition);
		this.setXPathAllSiblingsInParent();
		this.insertAtFromSiblingElementId(siblingElementId, targetPosition);
	}	
	
	private void insertAtFromSiblingElementId(String siblingElementId, int targetPosition) throws PaloulaXmlException {
		this.sequenceParentElement = new SequenceParentElement(this.xmlDocument, this.contentAttributes, siblingElementId);
		this.siblings = new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
		this.siblings.insertSequenceInsertElement(this.sequenceInsertElement, targetPosition);
	}
	
	/* ========================================================================== */	
	public void insertAtWithinTagNameSiblings(Element parentElement, Element insertElement, int targetPosition) throws PaloulaXmlException {
		this.setSequenceInsertElement(insertElement, targetPosition);
		this.setXPathByTagNameInParent(this.sequenceInsertElement.getTagName());
		this.insertAtFromParentElement(parentElement, targetPosition);
	}		

	public void insertAtWithinAllSiblings(Element parentElement, Element insertElement, int targetPosition) throws PaloulaXmlException {
		this.setSequenceInsertElement(insertElement, targetPosition);
		this.setXPathAllSiblingsInParent();
		this.insertAtFromParentElement(parentElement, targetPosition);
	}	
	
	private void insertAtFromParentElement(Element parentElement, int targetPosition) throws PaloulaXmlException {
		this.sequenceParentElement = new SequenceParentElement(this.xmlDocument, this.contentAttributes, parentElement);
		this.siblings = new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
		this.siblings.insertSequenceInsertElement(this.sequenceInsertElement, targetPosition);
	}
	
	private void setSequenceInsertElement(Element insertElement, int targetPosition) throws PaloulaXmlException {
		this.sequenceInsertElement = new SequenceInsertElement(this.xmlDocument, this.contentAttributes, insertElement, targetPosition);
	}
	
	private void setXPathByTagNameInParent(String tagName) {
		 this.siblingsXPath = "./" + tagName; ;
	}
	
	private void setXPathAllSiblingsInParent() {
		 this.siblingsXPath = "./*";
	}
	
}
