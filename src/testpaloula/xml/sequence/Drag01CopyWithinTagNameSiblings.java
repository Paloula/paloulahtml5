package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;
import de.paloula.xml.sequence.SequenceDrag;

public class Drag01CopyWithinTagNameSiblings {

	public static void copyWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(null, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinTagNameSiblings04() {
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
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinTagNameSiblings05() {
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
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: targetId already exists
	 */
	public static void copyWithinTagNameSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "b";
			SequenceDrag.copyElementWithinTagNameSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinTagNameSiblings07() {
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
			//String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinTagNameSiblings08() {
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
			SequenceDrag.copyElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinTagNameSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "bbb";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinTagNameSiblings(sourceSequenceDrag, dragElement, sourceSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		copyWithinTagNameSiblings01();
		//copyWithinTagNameSiblings02();
		//copyWithinTagNameSiblings03();
		//copyWithinTagNameSiblings04();
		//copyWithinTagNameSiblings05();
		//copyWithinTagNameSiblings06();
		//copyWithinTagNameSiblings07();
		//copyWithinTagNameSiblings08();
		//copyWithinTagNameSiblings09();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
