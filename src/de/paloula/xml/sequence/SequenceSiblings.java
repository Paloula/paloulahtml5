package de.paloula.xml.sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceSiblings {
	
	private Document xmlDocument = null;
	private ContentAttributes contentAttributeNames = new ContentAttributes();
	private SequenceParentElement sequenceParentElement;
	private int startPosSequence = 1;
	private String siblingsXPath = null;
	private SequenceSiblings siblings;

	public SequenceSiblings(Document xmlDocument, ContentAttributes contentAttributeNames, SequenceParentElement sequenceParentElement, int startPosSequence, String siblingsXPath) throws PaloulaXmlException {		
		this.xmlDocument = xmlDocument;
		this.contentAttributeNames = contentAttributeNames;
		this.sequenceParentElement = sequenceParentElement;
		this.startPosSequence = startPosSequence;
		this.siblingsXPath = siblingsXPath;
		this.siblings = this;
		this.repairSequenceList();
	}	
	
	public int getMaxPosShiftOfSiblingElementsOfParent() throws PaloulaXmlException {
		List<SequenceSiblingElement> sequenceSiblings = this.getSortedSequenceSiblings();
		int numberOfAllSiblings = sequenceSiblings.size();
		int maxPos = this.startPosSequence + numberOfAllSiblings - 1;
		
		if (numberOfAllSiblings > 0) {
			sequenceSiblings.get(numberOfAllSiblings - 1).getPosition();
		}
		
		return maxPos;	
	}

	private List<SequenceSiblingElement> getSortedSequenceSiblings() throws PaloulaXmlException {
		List<Element> sequenceSiblingElements = this.getSequenceSiblingElements();
		List<SequenceSiblingElement> sortedSequenceSiblings = new ArrayList<>();		
		
		for (Element siblingElement : sequenceSiblingElements) {
			SequenceSiblingElement sequenceSibling = new SequenceSiblingElement(siblingElement, this.contentAttributeNames);
			sortedSequenceSiblings.add(sequenceSibling);
		}	
		
        Collections.sort(sortedSequenceSiblings);
 
        return sortedSequenceSiblings;
 	}	
	
	private List<Element> getSequenceSiblingElements() {
		List<Element> sequenceSiblingElements = JDomXPath.getList(this.siblingsXPath, this.sequenceParentElement.getParentElement());
		
		return sequenceSiblingElements;
	}	
	
	private void repairSequenceList() throws PaloulaXmlException {
		int positionCounterStart = this.startPosSequence;
		List<SequenceSiblingElement> sortedSequenceSiblings = this.getSortedSequenceSiblings();
		
		for (SequenceSiblingElement sequenceSibling : sortedSequenceSiblings) {
			sequenceSibling.changePosition(positionCounterStart);
			positionCounterStart = positionCounterStart + 1;
		}
	}
	
	public void shiftNowByDirection(SequenceShiftElement sequenceShiftElement, SequenceSiblings siblings) throws PaloulaXmlException {
		this.repairSequenceList();
		//sequenceShiftElement.setVerifiedTargetPosition(this.startPosSequence, this.sequenceParentElement, siblings, this.siblingsXPath);
		sequenceShiftElement.setVerifiedTargetPosition(this.startPosSequence, this.sequenceParentElement, this.siblings, this.siblingsXPath);
		
		Integer shiftPosition = sequenceShiftElement.getPosition();
		int targetPosition = sequenceShiftElement.getTargetPosition();
		
		if (targetPosition > shiftPosition) {
			this.shiftNowUp(shiftPosition, targetPosition);
		} else if (targetPosition < shiftPosition) {
			this.shiftNowDown(shiftPosition, targetPosition);
		}
		
		sequenceShiftElement.changePosition(targetPosition);
	}		
	
	private void shiftNowUp(Integer shiftElementPosition, int targetPosition) {
		String positionAttributeName = this.contentAttributeNames.getPositionAttributeName();

		for (Element siblingElement : this.getSequenceSiblingElements()) {
			String sequenceSiblingPos = siblingElement.getAttributeValue(positionAttributeName);
			Integer siblingElementPositionInteger = Integer.parseInt(sequenceSiblingPos);
			
			if (siblingElementPositionInteger >= shiftElementPosition && siblingElementPositionInteger <= targetPosition ) {
				siblingElement.setAttribute(positionAttributeName, siblingElementPositionInteger - 1 + "");
			}			
		}			
	}
	
	private void shiftNowDown(Integer shiftElementPosition, int targetPosition) {
		String positionAttributeName = this.contentAttributeNames.getPositionAttributeName();
		
		for (Element siblingElement : this.getSequenceSiblingElements()) {
			String sequenceSiblingPos = siblingElement.getAttributeValue(positionAttributeName);
			Integer siblingElementPositionInteger = Integer.parseInt(sequenceSiblingPos);
			
			if (siblingElementPositionInteger >= targetPosition && siblingElementPositionInteger <= shiftElementPosition ) {
				siblingElement.setAttribute(positionAttributeName, siblingElementPositionInteger + 1 + "");
			}			
		}			
	}	
	
	public void insertSequenceInsertElement(SequenceInsertElement sequenceInsertElement, int targetPosition) throws PaloulaXmlException {
		this.repairSequenceList();		
		this.insertElement(sequenceInsertElement);
		this.shiftInsertElement(sequenceInsertElement);
	}
	
	private void insertElement(SequenceInsertElement sequenceInsertElement) throws PaloulaXmlException {
		int insertPosition = this.getMaxPosShiftOfSiblingElementsOfParent() + 10000;
		Element insertElement = sequenceInsertElement.getInsertElement();
		insertElement.setAttribute(this.contentAttributeNames.getPositionAttributeName(), insertPosition + "");
		this.sequenceParentElement.getParentElement().addContent(insertElement);
	}
	
	private void shiftInsertElement(SequenceInsertElement sequenceInsertElement) throws PaloulaXmlException {
		Sequence sequenceShift = new Sequence(this.xmlDocument, this.contentAttributeNames);
		Element insertElement = sequenceInsertElement.getInsertElement();
		int targetPosition = sequenceInsertElement.getTargetPosition();
		
		if (this.siblingsXPath.contains("*")) {
			sequenceShift.shiftWithinAllSiblings(insertElement, targetPosition);
		} else {
			sequenceShift.shiftWithinTagNameSiblings(insertElement, targetPosition);
		}		
	}
}
