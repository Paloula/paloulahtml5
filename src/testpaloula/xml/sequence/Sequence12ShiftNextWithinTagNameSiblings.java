package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence12ShiftNextWithinTagNameSiblings {

	public static void shiftNextWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "b";
			sequenceShift.shiftNextWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftNextWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "d";
			sequenceShift.shiftNextWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftNextWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet03();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributeNames);
			
			String elementId = "a";
			sequenceShift.shiftNextWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void shiftNextWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet04();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = -2;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributes);

			String elementId = "a";
			sequenceShift.shiftNextWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void shiftNextWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);
			
			sequenceShift.shiftNextWithinTagNameSiblings(shiftElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		shiftNextWithinTagNameSiblings01();
		shiftNextWithinTagNameSiblings02();
		shiftNextWithinTagNameSiblings03();
		shiftNextWithinTagNameSiblings04();
		shiftNextWithinTagNameSiblings05();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
