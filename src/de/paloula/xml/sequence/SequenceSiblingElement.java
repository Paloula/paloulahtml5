package de.paloula.xml.sequence;

import org.jdom2.Element;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceSiblingElement implements Comparable<Object> {

	private String siblingIdAttributeName;
	private String siblingPositionAttributeName;
	private String id;
	private Integer position;
	private Element siblingElement;

	public SequenceSiblingElement(Element siblingElement, ContentAttributes contentAttributeNames) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(siblingElement, "Sibling element");		
		this.siblingElement = siblingElement;
		
		this.siblingIdAttributeName = contentAttributeNames.getIdAttributeName();
		this.setId();
		
		this.siblingPositionAttributeName = contentAttributeNames.getPositionAttributeName();
		this.setPosition();
	}
	
	public void setId() throws PaloulaXmlException {
		String siblingElementId = siblingElement.getAttributeValue(this.siblingIdAttributeName);	
		SequenceCheckExceptions.checkExceptionSequenceElementIdMissing(this.siblingElement, this.siblingIdAttributeName);
		this.id = siblingElementId;
	}

	public Integer getPosition() {
		return position;
	}
	
	private void setPosition() throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionSequenceElementPositionMissing(siblingElement, this.siblingPositionAttributeName, this.id);			
		String siblingElementPosition = this.siblingElement.getAttributeValue(siblingPositionAttributeName);			
		Integer siblingElementPositionInteger = Integer.parseInt(siblingElementPosition);
		this.position = siblingElementPositionInteger;
	}
	
	public void changePosition(Integer newPosition) {
		this.siblingElement.setAttribute(this.siblingPositionAttributeName, newPosition + "");
		this.position = newPosition;
	}

    @Override
    public String toString() {
        return "SequenceSibling{id=" + this.id + " , position=" + this.position +"}";
    }	

	@Override
	public int compareTo(Object o) {		
		return this.getPosition().compareTo(((SequenceSiblingElement) o).getPosition());
	}

}
