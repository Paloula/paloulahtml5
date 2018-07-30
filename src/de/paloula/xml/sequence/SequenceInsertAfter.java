package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceInsertAfter {
	
	private Document xmlDocument;
	private ContentAttributes contentAttributes = new ContentAttributes();

	public SequenceInsertAfter(Document xmlDocument, ContentAttributes contentAttributes) {
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
	}
	
	public void insertAfterWithinTagNameSiblings(String afterElementId, Element insertElement) throws PaloulaXmlException {
		SequenceElement sequenceAfterElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, afterElementId);
		SequenceCheckExceptions.checkExceptionElementsUnequalTagName(insertElement, sequenceAfterElement.getElement());
		int afterPosition = sequenceAfterElement.getAfterPosition();		
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinTagNameSiblings(afterElementId, insertElement, afterPosition);
	}	
	
	public void insertAfterWithinAllSiblings(String afterElementId, Element insertElement) throws PaloulaXmlException {
		SequenceElement sequenceAfterElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, afterElementId);
		int afterPosition = sequenceAfterElement.getAfterPosition();
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinAllSiblings(afterElementId, insertElement, afterPosition);
	}

	public void insertAfterWithinTagNameSiblings(Element afterElement, Element insertElement) throws PaloulaXmlException {
		SequenceElement sequenceAfterElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, afterElement);
		SequenceCheckExceptions.checkExceptionElementsUnequalTagName(insertElement, sequenceAfterElement.getElement());
		String afterElementId = sequenceAfterElement.getElementId();
		int afterPosition = sequenceAfterElement.getAfterPosition();
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinTagNameSiblings(afterElementId, insertElement, afterPosition);
	}	
	
	public void insertAfterWithinAllSiblings(Element afterElement, Element insertElement) throws PaloulaXmlException {	
		SequenceElement sequenceAfterElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, afterElement);
		String afterElementId = sequenceAfterElement.getElementId();
		int afterPosition = sequenceAfterElement.getAfterPosition();
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinAllSiblings(afterElementId, insertElement, afterPosition);
	}
	
}
