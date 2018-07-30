package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceInsertBefore {
	
	private Document xmlDocument;
	private ContentAttributes contentAttributes = new ContentAttributes();

	public SequenceInsertBefore(Document xmlDocument, ContentAttributes contentAttributes) {
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
	}
	
	public void insertBeforeWithinTagNameSiblings(String beforeElementId, Element insertElement) throws PaloulaXmlException {
		SequenceElement sequenceBeforeElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, beforeElementId);
		SequenceCheckExceptions.checkExceptionElementsUnequalTagName(insertElement, sequenceBeforeElement.getElement());
		int beforePosition = sequenceBeforeElement.getBeforePosition();		
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinTagNameSiblings(beforeElementId, insertElement, beforePosition);
	}	
	
	public void insertBeforeWithinAllSiblings(String beforeElementId, Element insertElement) throws PaloulaXmlException {
		SequenceElement sequenceBeforeElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, beforeElementId);
		int beforePosition = sequenceBeforeElement.getBeforePosition();
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinAllSiblings(beforeElementId, insertElement, beforePosition);
	}

	public void insertBeforeWithinTagNameSiblings(Element beforeElement, Element insertElement) throws PaloulaXmlException {
		SequenceElement sequenceBeforeElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, beforeElement);
		SequenceCheckExceptions.checkExceptionElementsUnequalTagName(insertElement, sequenceBeforeElement.getElement());
		String beforeElementId = sequenceBeforeElement.getElementId();
		int beforePosition = sequenceBeforeElement.getBeforePosition();
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinTagNameSiblings(beforeElementId, insertElement, beforePosition);
	}	
	
	public void insertBeforeWithinAllSiblings(Element beforeElement, Element insertElement) throws PaloulaXmlException {	
		SequenceElement sequenceBeforeElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, beforeElement);
		String beforeElementId = sequenceBeforeElement.getElementId();
		int beforePosition = sequenceBeforeElement.getBeforePosition();
		SequenceInsertAt sequenceInsert = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsert.insertAtWithinAllSiblings(beforeElementId, insertElement, beforePosition);
	}
	
}
