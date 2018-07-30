package de.paloula.xml.sequence;

import org.jdom2.Element;

import com.sun.istack.internal.NotNull;

import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceDrag {
	
	private SequenceDrag() {		
	}	

	/* ------------------------------------------------------------------------- */
	// Same document - Within tag name siblings
	public static void copyElementWithinTagNameSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Element targetParentElement, int targetPosition, @NotNull String targetId) throws PaloulaXmlException {
		Element copyDragElement = SequenceDrag.getSameDocumentDragElement(sourceSequence, dragElement);
		SequenceDrag.changeElementId(sourceSequence, copyDragElement, targetId);
		sourceSequence.insertAtWithinTagNameSiblings(targetParentElement, copyDragElement, targetPosition);
	}
	
	// Same document - Within all siblings
	public static void copyElementWithinAllSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Element targetParentElement, int targetPosition, @NotNull String targetId) throws PaloulaXmlException {
		Element copyDragElement = SequenceDrag.getSameDocumentDragElement(sourceSequence, dragElement);
		SequenceDrag.changeElementId(sourceSequence, copyDragElement, targetId);
		sourceSequence.insertAtWithinAllSiblings(targetParentElement, copyDragElement, targetPosition);
	}

	// Same document - Within tag name siblings
	public static void moveElementWithinTagNameSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Element targetParentElement, int targetPosition) throws PaloulaXmlException {
		Element moveDragElement = SequenceDrag.getSameDocumentDragElement(sourceSequence, dragElement);
		sourceSequence.deleteWithinTagNameSiblings(dragElement);
		sourceSequence.insertAtWithinTagNameSiblings(targetParentElement, moveDragElement, targetPosition);
	}
	
	// Same document - Within all siblings
	public static void moveElementWithinAllSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Element targetParentElement, int targetPosition) throws PaloulaXmlException {
		Element moveDragElement = SequenceDrag.getSameDocumentDragElement(sourceSequence, dragElement);
		sourceSequence.deleteWithinAllSiblings(dragElement);
		sourceSequence.insertAtWithinAllSiblings(targetParentElement, moveDragElement, targetPosition);
	}	
	
	private static Element getSameDocumentDragElement(Sequence sourceSequence, Element dragElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionSequenceIsNull(sourceSequence);
		SequenceDragElement sequenceDragElement = new SequenceDragElement(sourceSequence, dragElement);
		Element dragElementClone = sequenceDragElement.getDragElementClone();
		
		return dragElementClone;
	}

	/* ------------------------------------------------------------------------- */
	// Different documents - Within tag name siblings
	public static void copyElementWithinTagNameSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition) throws PaloulaXmlException {
		Element copyDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);		
		SequenceDrag.transferElementId(sourceSequence, targetSequence, copyDragElement);
		targetSequence.insertAtWithinTagNameSiblings(targetParentElement, copyDragElement, targetPosition);
	}	

	// Different documents - Within tag name siblings
	public static void copyElementWithinTagNameSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition, @NotNull String targetId) throws PaloulaXmlException {
		Element copyDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.changeElementId(sourceSequence, targetSequence, copyDragElement, targetId);
		targetSequence.insertAtWithinTagNameSiblings(targetParentElement, copyDragElement, targetPosition);
	}	
	
	// Different documents - Within all siblings
	public static void copyElementWithinAllSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition) throws PaloulaXmlException {
		Element copyDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.transferElementId(sourceSequence, targetSequence, copyDragElement);
		targetSequence.insertAtWithinAllSiblings(targetParentElement, copyDragElement, targetPosition);
	}	

	// Different documents - Within all siblings
	public static void copyElementWithinAllSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition, @NotNull String targetId) throws PaloulaXmlException {
		Element copyDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.changeElementId(sourceSequence, targetSequence, copyDragElement, targetId);
		targetSequence.insertAtWithinAllSiblings(targetParentElement, copyDragElement, targetPosition);
	}	
	
	// Different documents - Within tag name siblings
	public static void moveElementWithinTagNameSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition, @NotNull String targetId) throws PaloulaXmlException {
		Element moveDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.changeElementId(sourceSequence, targetSequence, moveDragElement, targetId);
		sourceSequence.deleteWithinTagNameSiblings(dragElement);
		targetSequence.insertAtWithinTagNameSiblings(targetParentElement, moveDragElement, targetPosition);
	}	
	
	// Different documents - Within tag name siblings
	public static void moveElementWithinTagNameSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition) throws PaloulaXmlException {
		Element moveDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.transferElementId(sourceSequence, targetSequence, moveDragElement);
		sourceSequence.deleteWithinTagNameSiblings(dragElement);
		targetSequence.insertAtWithinTagNameSiblings(targetParentElement, moveDragElement, targetPosition);
	}	

	// Different documents - Within all siblings
	public static void moveElementWithinAllSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition, @NotNull String targetId) throws PaloulaXmlException {
		Element moveDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.changeElementId(sourceSequence, targetSequence, moveDragElement, targetId);
		sourceSequence.deleteWithinAllSiblings(dragElement);
		targetSequence.insertAtWithinAllSiblings(targetParentElement, moveDragElement, targetPosition);
	}
	
	// Different documents - Within all siblings
	public static void moveElementWithinAllSiblings(@NotNull Sequence sourceSequence, @NotNull Element dragElement, @NotNull Sequence targetSequence, @NotNull Element targetParentElement, int targetPosition) throws PaloulaXmlException {
		Element moveDragElement = SequenceDrag.getDifferentDocumentsDragElement(sourceSequence, dragElement, targetSequence);
		SequenceDrag.transferElementId(sourceSequence, targetSequence, moveDragElement);
		sourceSequence.deleteWithinAllSiblings(dragElement);
		targetSequence.insertAtWithinAllSiblings(targetParentElement, moveDragElement, targetPosition);
	}

	private static Element getDifferentDocumentsDragElement(Sequence sourceSequence, Element dragElement, Sequence targetSequence) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionSequenceIsNull(sourceSequence);
		SequenceCheckExceptions.checkExceptionSequenceIsNull(targetSequence);
		SequenceDragElement sequenceDragElement = new SequenceDragElement(sourceSequence, dragElement);
		Element dragElementClone = sequenceDragElement.getDragElementClone();
		
		return dragElementClone;
	}

	/* ------------------------------------------------------------------------- */
	private static void transferElementId(Sequence sourceSequence, Sequence targetSequence, Element element) {
		String sourceId = SequenceDrag.getElementId(sourceSequence, element);
		SequenceDrag.removeIdAndPositionAttributes(sourceSequence, element);		
		SequenceDrag.changeElementId(targetSequence, element, sourceId);
	}

	private static void changeElementId(Sequence sourceSequence, Sequence targetSequence, Element element, @NotNull String targetId) {
		SequenceDrag.removeIdAndPositionAttributes(sourceSequence, element);
		SequenceDrag.changeElementId(targetSequence, element, targetId);
	}
	
	private static void changeElementId(Sequence sequence, Element element, String targetId) {
		ContentAttributes contentAttributes = sequence.getContentAttributes();		
		element.setAttribute(contentAttributes.getIdAttributeName(), targetId);
	}

	private static String getElementId(Sequence sequence, Element element) {
		ContentAttributes contentAttributes = sequence.getContentAttributes();		
		String idAttributeName = contentAttributes.getIdAttributeName();
		String id = element.getAttributeValue(idAttributeName);
		
		return id;
	}
	
	private static void removeIdAndPositionAttributes(Sequence sequence, Element element) {
		ContentAttributes contentAttributes = sequence.getContentAttributes();		
		String idAttributeName = contentAttributes.getIdAttributeName();
		String positionAttributeName = contentAttributes.getIdAttributeName();
		element.removeAttribute(idAttributeName);
		element.removeAttribute(positionAttributeName);
	}

}
