package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;
import de.paloula.xml.sequence.SequenceDrag;

public class Drag04MoveWithinAllSiblings {

	public static void moveWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
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
	public static void moveWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			SequenceDrag.moveElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
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
	public static void moveWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			SequenceDrag.moveElementWithinAllSiblings(null, dragElement, targetParentElement, targetPosition);
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
	public static void moveWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument02);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
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
	public static void moveWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument02);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinAllSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
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
			SequenceDrag.moveElementWithinAllSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinAllSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "bbb";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.moveElementWithinAllSiblings(sourceSequenceDrag, dragElement, sourceSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void moveWithinAllSiblings10() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet16();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument02);
			Sequence targetSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "xyz";
			Element dragElement = JDomXPath.getFirstElement("//c[@id='" + elementId + "']", exampleDocument02);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.moveElementWithinAllSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void moveWithinAllSiblings11() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet16();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument02);
			Sequence targetSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "d4";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument02);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			SequenceDrag.moveElementWithinAllSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//moveWithinAllSiblings01();
		//moveWithinAllSiblings02();
		//moveWithinAllSiblings03();
		//moveWithinAllSiblings04();
		//moveWithinAllSiblings05();
		//moveWithinAllSiblings07();
		//moveWithinAllSiblings09();
		//moveWithinAllSiblings10();
		moveWithinAllSiblings11();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
