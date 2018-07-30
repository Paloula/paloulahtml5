package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import com.sun.istack.internal.NotNull;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceShift {

	private Document xmlDocument;
	private ContentAttributes contentAttributes = new ContentAttributes();
	private SequenceParentElement sequenceParentElement;
	private SequenceShiftElement sequenceShiftElement;
	private SequenceSiblings siblings;
	private String siblingsXPath = null;
	private int startPosSequence = 1;
	
	public SequenceShift(Document xmlDocument, ContentAttributes contentAttributes) {
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
		this.startPosSequence = contentAttributes.getStartPosSequence();
	}
	
	public void shiftWithinTagNameSiblings(@NotNull String shiftElementId, int targetPosition) throws PaloulaXmlException {
		this.setSequenceShiftElement(shiftElementId, targetPosition);
		shiftWithinTagNameSiblings(targetPosition);
	}	
	
	public void shiftWithinTagNameSiblings(@NotNull Element shiftElement, int targetPosition) throws PaloulaXmlException {
		this.setSequenceShiftElement(shiftElement, targetPosition);
		shiftWithinTagNameSiblings(targetPosition);
	}	
	
	private void shiftWithinTagNameSiblings(int targetPosition) throws PaloulaXmlException {
		this.setXPathByTagNameInParent(this.sequenceShiftElement.getTagName());
		this.setSequenceParentElement();
		this.siblings = new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
		this.initShiftSequence();
	}
	
	/* ========================================================================== */
	public void shiftWithinAllSiblings(@NotNull String shiftElementId, int targetPosition) throws PaloulaXmlException {
		this.setSequenceShiftElement(shiftElementId, targetPosition);
		this.shiftWithinAllSiblings(targetPosition);
	}
	
	public void shiftWithinAllSiblings(@NotNull Element shiftElement, int targetPosition) throws PaloulaXmlException {
		this.setSequenceShiftElement(shiftElement, targetPosition);
		this.shiftWithinAllSiblings(targetPosition);
	}
	
	private void shiftWithinAllSiblings(int targetPosition) throws PaloulaXmlException {
		this.setXPathAllSiblingsInParent();
		this.setSequenceParentElement();
		this.siblings = new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
		this.initShiftSequence();
	}

	private void setSequenceShiftElement(String shiftElementId, int targetPosition) throws PaloulaXmlException {
		this.sequenceShiftElement = new SequenceShiftElement(this.xmlDocument, this.contentAttributes, shiftElementId, targetPosition);
	}
	
	private void setSequenceShiftElement(Element shiftElement, int targetPosition) throws PaloulaXmlException {
		this.sequenceShiftElement = new SequenceShiftElement(this.xmlDocument, this.contentAttributes, shiftElement, targetPosition);
	}

	private void setSequenceParentElement() throws PaloulaXmlException {
		this.sequenceParentElement = new SequenceParentElement(this.xmlDocument, this.contentAttributes, this.sequenceShiftElement.getParentElement());
	}
	
	private void initShiftSequence() throws PaloulaXmlException {
		this.siblings.shiftNowByDirection(this.sequenceShiftElement, this.siblings) ;
	}
	
	private void setXPathByTagNameInParent(String tagName) {
		 this.siblingsXPath = "./" + tagName; ;
	}
	
	private void setXPathAllSiblingsInParent() {
		 this.siblingsXPath = "./*";
	}
}
