package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;
import de.paloula.xml.sequence.SequenceDrag;

public class Drag02MoveWithinTagNameSiblings {

	public static void moveWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: dragElement and targetParentElement are the same
	 */
	public static void moveWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			SequenceDrag.moveElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Sequence null
	 */
	public static void moveWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			SequenceDrag.moveElementWithinTagNameSiblings(null, dragElement, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: DragElement is not part of source
	 */
	public static void moveWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument02);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: targetParentElement is not part of source
	 */
	public static void moveWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument02);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinTagNameSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet16();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument02);
			Sequence targetSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b2";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument02);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.moveElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinTagNameSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet16();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument02);
			Sequence targetSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b2";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument02);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.moveElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinTagNameSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "bbb";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.moveElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, sourceSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinTagNameSiblings10() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "bbb";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, sourceSequenceDrag, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//moveWithinTagNameSiblings01();
		//moveWithinTagNameSiblings02();
		//moveWithinTagNameSiblings03();
		//moveWithinTagNameSiblings04();
		//moveWithinTagNameSiblings05();
		//moveWithinTagNameSiblings07();
		//moveWithinTagNameSiblings08();
		//moveWithinTagNameSiblings09();
		moveWithinTagNameSiblings10();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
