package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceShiftElement {
	
	private Document xmlDocument = null;
	private Element shiftElement = null;
	private ContentAttributes contentAttributes = null;
	private String shiftElementTagName;
	private int targetPosition = 1;
	
	
	public SequenceShiftElement(Document xmlDocument, ContentAttributes contentAttributes, String shiftElementId, int targetPosition) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionStringIsNullOrEmpty(shiftElementId, "Shift element id");		
		
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
		this.targetPosition = targetPosition;		
		this.setShiftElementById(shiftElementId);
		this.setTagName();
	}	
	
	public SequenceShiftElement(Document xmlDocument, ContentAttributes contentAttributes, Element shiftElement, int targetPosition) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(shiftElement, "Shift Element");
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(xmlDocument, shiftElement);
		
		this.xmlDocument = xmlDocument;		
		this.contentAttributes = contentAttributes;
		this.targetPosition = targetPosition;		
		this.setSetShiftElementByElement(shiftElement);
		this.setTagName();
	}
	
	public void setVerifiedTargetPosition(int startPosSequence, SequenceParentElement parentOfSequence, SequenceSiblings siblings, String siblingsXPath) throws PaloulaXmlException {
		int verifiedTargetPosition = this.getVerifiedTargetPositionLower(this.getTargetPosition(), startPosSequence);
		verifiedTargetPosition = this.getVerifiedTargetPositionUpper(verifiedTargetPosition, startPosSequence, parentOfSequence, siblings, siblingsXPath);
		
		this.setTargetPosition(verifiedTargetPosition);
	}		

	private int getVerifiedTargetPositionLower(int targetPosition, int startPosSequence) {
		int verifiedTargetPosition = targetPosition;
		
		if (targetPosition < startPosSequence) {
			verifiedTargetPosition = startPosSequence;
		}
		
		return verifiedTargetPosition;
	}
	
	private int getVerifiedTargetPositionUpper(int targetPosition, int startPosSequence, SequenceParentElement parentOfSequence, SequenceSiblings siblings, String siblingsXPath) throws PaloulaXmlException {
		int verifiedTargetPosition = targetPosition;
		int maxPosOfSiblings = siblings.getMaxPosShiftOfSiblingElementsOfParent();
		
		if (targetPosition > maxPosOfSiblings) {
			verifiedTargetPosition = maxPosOfSiblings;
		}
		
		return verifiedTargetPosition;
	}	
	
	private void setShiftElementById(String shiftElementId) throws PaloulaXmlException {
		String xpathTargetElement = "//*[@" + this.contentAttributes.getIdAttributeName() + "='" + shiftElementId + "']";
		Element shiftElement = JDomXPath.getFirstElement(xpathTargetElement, this.xmlDocument);		
		SequenceCheckExceptions.checkExceptionElementNull(shiftElement, this.contentAttributes.getIdAttributeName(), shiftElementId);
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(shiftElement, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, shiftElement);
		
		this.shiftElement = shiftElement;		
	}
	
	private void setSetShiftElementByElement(Element shiftElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(shiftElement, this.contentAttributes.getIdAttributeName(), "");
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(shiftElement, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, shiftElement);
		
		this.shiftElement = shiftElement;		
	}	
	
	private void setTagName() {
		this.shiftElementTagName = this.shiftElement.getName();
	}
	
	public String getTagName() {
		return this.shiftElementTagName;
	}
	
	public Element getParentElement() {
		return this.shiftElement.getParentElement();
	}
	
	public int getTargetPosition() {
		return this.targetPosition;
	}
	
	private void setTargetPosition(int targetPosition) {
		this.targetPosition = targetPosition;
	}	
	
	public Integer getPosition() {
		String attributePosition = this.shiftElement.getAttributeValue(this.contentAttributes.getPositionAttributeName());
		Integer position = Integer.parseInt(attributePosition);
		
		return position;
	}
	
	public void changePosition(int newPosition) {
		this.shiftElement.setAttribute(this.contentAttributes.getPositionAttributeName(), newPosition + "");
	}
	
}
