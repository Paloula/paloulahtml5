package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence02ShiftWithinAllSiblings {

	public static void shiftWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			int targetPosition = 3;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet06();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			int targetPosition = 4;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet07();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributeNames);
			
			String elementId = "a";
			int targetPosition = 4;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
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
	public static void shiftWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet07();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");

			Sequence sequenceShift = new Sequence(exampleDocument01, null);
			
			String elementId = "a";
			int targetPosition = 4;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
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
	public static void shiftWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet07();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");

			Sequence sequenceShift = new Sequence(null, contentAttributeNames);
			String elementId = "a";
			int targetPosition = 4;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void shiftWithinAllSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet08();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = -2;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributes);
			String elementId = "d";
			int targetPosition = -1;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
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
	public static void shiftWithinAllSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "e";
			int targetPosition = 2;
			sequenceShift.shiftWithinAllSiblings(elementId, targetPosition);
			System.out.println(elementId + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void shiftWithinAllSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);
			
			int targetPosition = 2;
			sequenceShift.shiftWithinAllSiblings(shiftElement, targetPosition);
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
	public static void shiftWithinAllSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		Document exampleDocument02 = TestDocuments.getExampleDocumet06();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument02);
			
			int targetPosition = 2;
			sequenceShift.shiftWithinAllSiblings(shiftElement, targetPosition);
			System.out.println(shiftElement.getAttributeValue("id") + " to " + targetPosition);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();

		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//shiftWithinAllSiblings01();
		//shiftWithinAllSiblings02();
		//shiftWithinAllSiblings03();
		//shiftWithinAllSiblings04();
		//shiftWithinAllSiblings05();
		//shiftWithinAllSiblings06();
		//shiftWithinAllSiblings07();
		shiftWithinAllSiblings08();
		//shiftWithinAllSiblings09();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}
}
