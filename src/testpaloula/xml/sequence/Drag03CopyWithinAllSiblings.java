package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;
import de.paloula.xml.sequence.SequenceDrag;

public class Drag03CopyWithinAllSiblings {

	public static void copyWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "bbb";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//b[2]", exampleDocument01);
			int targetPosition = 3;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(null, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinAllSiblings04() {
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
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinAllSiblings05() {
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
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
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
	public static void copyWithinAllSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDrag = new Sequence(exampleDocument01);
			String elementId = "b";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[2]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "b";
			SequenceDrag.copyElementWithinAllSiblings(sequenceDrag, dragElement, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinAllSiblings07() {
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
			//String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinAllSiblings08() {
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
			SequenceDrag.copyElementWithinAllSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinAllSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sourceSequenceDrag = new Sequence(exampleDocument01);
			String elementId = "bbb";
			Element dragElement = JDomXPath.getFirstElement("//b[@id='" + elementId + "']", exampleDocument01);
			Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
			int targetPosition = 1;
			String targetId = "qwertz";
			SequenceDrag.copyElementWithinAllSiblings(sourceSequenceDrag, dragElement, sourceSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void copyWithinAllSiblings10() {
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
			SequenceDrag.copyElementWithinAllSiblings(sourceSequenceDrag, dragElement, targetSequenceDrag, targetParentElement, targetPosition, targetId);
			System.out.println(elementId + " to " + targetPosition + " at " + targetParentElement + targetParentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//copyWithinAllSiblings01();
		//copyWithinAllSiblings02();
		//copyWithinAllSiblings03();
		//copyWithinAllSiblings04();
		//copyWithinAllSiblings05();
		//copyWithinAllSiblings06();
		//copyWithinAllSiblings07();
		//copyWithinAllSiblings08();
		//copyWithinAllSiblings09();
		copyWithinAllSiblings10();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
