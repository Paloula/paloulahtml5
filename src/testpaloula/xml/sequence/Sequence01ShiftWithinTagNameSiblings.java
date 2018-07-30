package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence01ShiftWithinTagNameSiblings {

	public static void shiftWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			int targetPosition = 3;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet02();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			int targetPosition = 4;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet03();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributeNames);
			
			String elementId = "a";
			int targetPosition = 4;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Exception: ContentAttributeNames null
	 */
	public static void shiftWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet03();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");

			Sequence sequenceShift = new Sequence(exampleDocument01, null);
			
			String elementId = "a";
			int targetPosition = 4;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: XML Document null
	 */
	public static void shiftWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet03();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");

			Sequence sequenceShift = new Sequence(null, contentAttributeNames);
			String elementId = "a";
			int targetPosition = 4;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void shiftWithinTagNameSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet04();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = -2;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributes);

			String elementId = "d";
			int targetPosition = -1;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: No shift element with given id
	 */
	public static void shiftWithinTagNameSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "e";
			int targetPosition = 2;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void shiftWithinTagNameSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);
			
			int targetPosition = 2;
			sequenceShift.shiftWithinTagNameSiblings(shiftElement, targetPosition);
			System.out.println(shiftElement.getAttributeValue("id") + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Shift element is not a part of the document
	 */
	public static void shiftWithinTagNameSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet02();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument02);
			
			int targetPosition = 2;
			sequenceShift.shiftWithinTagNameSiblings(shiftElement, targetPosition);
			System.out.println(shiftElement.getAttributeValue("id") + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();

		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: element(s) without id attribute in sequence
	 */
	public static void shiftWithinTagNameSiblings10() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet10();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			int targetPosition = 3;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: element(s) without position attribute in sequence
	 */
	public static void shiftWithinTagNameSiblings11() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet10();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			int targetPosition = 3;
			sequenceShift.shiftWithinTagNameSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//shiftWithinTagNameSiblings01();
		//shiftWithinTagNameSiblings02();
		shiftWithinTagNameSiblings03();
		//shiftWithinTagNameSiblings04();
		//shiftWithinTagNameSiblings05();
		//shiftWithinTagNameSiblings06();
		//shiftWithinTagNameSiblings07();
		//shiftWithinTagNameSiblings08();
		//shiftWithinTagNameSiblings09();
		//shiftWithinTagNameSiblings10();
		//shiftWithinTagNameSiblings11();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
