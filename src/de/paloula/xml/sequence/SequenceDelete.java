package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceDelete {
	
	private Document xmlDocument;
	private ContentAttributes contentAttributes = new ContentAttributes();
	private SequenceParentElement sequenceParentElement;
	private SequenceDeleteElement sequenceDeleteElement;
	private String siblingsXPath = null;
	private int startPosSequence = 1;

	public SequenceDelete(Document xmlDocument, ContentAttributes contentAttributes) {
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
		this.startPosSequence = contentAttributes.getStartPosSequence();
	}
	
	public void deleteWithinTagNameSiblings(String deleteElementId) throws PaloulaXmlException {
		this.sequenceDeleteElement = new SequenceDeleteElement(this.xmlDocument, this.contentAttributes, deleteElementId);
		this.setXPathByTagNameInParent(this.sequenceDeleteElement.getTagName());
		this.setSequenceParentElement();
		this.sequenceDeleteElement.getDeleteElement().detach();
		new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
	}

	public void deleteWithinTagNameSiblings(Element deleteElement) throws PaloulaXmlException {
		this.sequenceDeleteElement = new SequenceDeleteElement(this.xmlDocument, this.contentAttributes, deleteElement);
		this.setXPathByTagNameInParent(this.sequenceDeleteElement.getTagName());
		this.setSequenceParentElement();
		this.sequenceDeleteElement.getDeleteElement().detach();
		new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
	}

	public void deleteWithinAllSiblings(String deleteElementId) throws PaloulaXmlException {
		this.sequenceDeleteElement = new SequenceDeleteElement(this.xmlDocument, this.contentAttributes, deleteElementId);
		this.setXPathAllSiblingsInParent();
		this.setSequenceParentElement();
		this.sequenceDeleteElement.getDeleteElement().detach();
		new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
	}

	public void deleteWithinAllSiblings(Element deleteElement) throws PaloulaXmlException {
		this.sequenceDeleteElement = new SequenceDeleteElement(this.xmlDocument, this.contentAttributes, deleteElement);
		this.setXPathAllSiblingsInParent();
		this.setSequenceParentElement();
		this.sequenceDeleteElement.getDeleteElement().detach();
		new SequenceSiblings(this.xmlDocument, this.contentAttributes, this.sequenceParentElement, this.startPosSequence, this.siblingsXPath);
	}

	private void setSequenceParentElement() throws PaloulaXmlException {
		this.sequenceParentElement = new SequenceParentElement(this.xmlDocument, this.contentAttributes, this.sequenceDeleteElement.getParentElement());
	}
	
	private void setXPathByTagNameInParent(String tagName) {
		 this.siblingsXPath = "./" + tagName; ;
	}
	
	private void setXPathAllSiblingsInParent() {
		 this.siblingsXPath = "./*";
	}
}
