package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence14ShiftPreviousWithinTagNameSiblings {

	public static void shiftPreviousWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			sequenceShift.shiftPreviousWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftPreviousWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "d";
			sequenceShift.shiftPreviousWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftPreviousWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet03();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributeNames);
			
			String elementId = "a";
			sequenceShift.shiftPreviousWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void shiftPreviousWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet04();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = -2;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributes);

			String elementId = "a";
			sequenceShift.shiftPreviousWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void shiftPreviousWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);
			
			sequenceShift.shiftPreviousWithinTagNameSiblings(shiftElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		shiftPreviousWithinTagNameSiblings01();
		//shiftPreviousWithinTagNameSiblings02();
		//shiftPreviousWithinTagNameSiblings03();
		//shiftPreviousWithinTagNameSiblings04();
		//shiftPreviousWithinTagNameSiblings05();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
