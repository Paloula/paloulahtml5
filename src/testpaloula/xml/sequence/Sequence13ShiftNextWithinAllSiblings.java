package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence13ShiftNextWithinAllSiblings {

	public static void shiftNextWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "d";
			sequenceShift.shiftNextWithinAllSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftNextWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			String elementId = "xyz";
			sequenceShift.shiftNextWithinAllSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void shiftNextWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet07();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			ContentAttributes contentAttributeNames = new ContentAttributes();
			contentAttributeNames.setIdAttributeName("identity");
			contentAttributeNames.setPositionAttributeName("position");
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributeNames);
			
			String elementId = "a";
			sequenceShift.shiftNextWithinAllSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void shiftNextWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet04();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = -2;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceShift = new Sequence(exampleDocument01, contentAttributes);

			String elementId = "a";
			sequenceShift.shiftNextWithinAllSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void shiftNextWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceShift = new Sequence(exampleDocument01);
			Element shiftElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);
			
			sequenceShift.shiftNextWithinAllSiblings(shiftElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//shiftNextWithinAllSiblings01();
		//shiftNextWithinAllSiblings02();
		//shiftNextWithinAllSiblings03();
		//shiftNextWithinAllSiblings04();
		shiftNextWithinAllSiblings05();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
