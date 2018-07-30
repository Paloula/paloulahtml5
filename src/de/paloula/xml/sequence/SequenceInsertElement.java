package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceInsertElement {
	
	private Element insertElement = null;
	private String insertElementTagName;
	private int targetPosition = 1;
	
	public SequenceInsertElement(Document xmlDocument, ContentAttributes contentAttributeNames, Element insertElement, int targetPosition) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(insertElement, "Insert Element");
		SequenceCheckExceptions.checkExceptionIdAlreadyExists(xmlDocument, contentAttributeNames.getIdAttributeName(), insertElement);
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(insertElement, contentAttributeNames.getIdAttributeName());
		
		this.targetPosition = targetPosition;		
		this.setInsertElementByElement(insertElement);
		this.setInsertElementTagName();
	}	
	
	public Element getInsertElement() {
		return this.insertElement;
	}
	
	private void setInsertElementByElement(Element insertElement) throws PaloulaXmlException {
		this.insertElement = insertElement;		
	}	
	
	private void setInsertElementTagName() {
		this.insertElementTagName = this.insertElement.getName();
	}
	
	public String getTagName() {
		return this.insertElementTagName;
	}
	
	public int getTargetPosition() {
		return this.targetPosition;
	}
	
	
}
