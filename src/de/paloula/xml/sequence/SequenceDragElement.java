package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceDragElement {
	private ContentAttributes contentAttributes = new ContentAttributes();
	private Document xmlDocument = null;
	private Element dragElement = null;
	
	public SequenceDragElement(Sequence sequence, Element dragElement) throws PaloulaXmlException {
		// checkException sequence is null;
		this.contentAttributes = sequence.getContentAttributes();
		this.xmlDocument = sequence.getXmlDocument();
		
		this.setSetDragElementByElement(dragElement);
	}
	
	public SequenceDragElement(Sequence sequence, String dragElementId) throws PaloulaXmlException {
		// checkException sequence is null;
		this.contentAttributes = sequence.getContentAttributes();
		this.xmlDocument = sequence.getXmlDocument();
		
		this.setDragElementById(dragElementId);
	}

	private void setDragElementById(String dragElementId) throws PaloulaXmlException {
		String xpathTargetElement = "//*[@" + this.contentAttributes.getIdAttributeName() + "='" + dragElementId + "']";
		Element dragElement = JDomXPath.getFirstElement(xpathTargetElement, this.xmlDocument);		
		SequenceCheckExceptions.checkExceptionElementNull(dragElement, this.contentAttributes.getIdAttributeName(), dragElementId);
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(dragElement, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, dragElement);
		
		this.dragElement = dragElement;		
	}
	
	private void setSetDragElementByElement(Element dragElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(dragElement, this.contentAttributes.getIdAttributeName(), "");
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(dragElement, this.contentAttributes.getIdAttributeName());
		SequenceCheckExceptions.checkExceptionElementExistsInDocument(this.xmlDocument, dragElement);
		
		this.dragElement = dragElement;		
	}	
	
	public Element getDragElement() {
		return this.dragElement;
	}
	
	public Element getDragElementClone() {
		return this.dragElement.clone();
	}
	
	
}
