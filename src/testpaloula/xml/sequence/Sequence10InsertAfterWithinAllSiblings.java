package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class Sequence10InsertAfterWithinAllSiblings {

	public static void insertAfterWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String afterElementId = "a";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertAfterWithinAllSiblings(afterElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet06();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String afterElementId = "d";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertAfterWithinAllSiblings(afterElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet06();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String afterElementId = "xyz";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertAfterWithinAllSiblings(afterElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element afterElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElement +  afterElement.getAttributes());
			sequenceInsert.insertAfterWithinAllSiblings(afterElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element afterElement = JDomXPath.getFirstElement("//c[@id='xyz']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElement +  afterElement.getAttributes());
			sequenceInsert.insertAfterWithinAllSiblings(afterElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinAllSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element afterElement = JDomXPath.getFirstElement("//b[@id='d']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElement +  afterElement.getAttributes());
			sequenceInsert.insertAfterWithinAllSiblings(afterElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//insertAfterWithinAllSiblings01();
		//insertAfterWithinAllSiblings02();
		//insertAfterWithinAllSiblings03();
		//insertAfterWithinAllSiblings04();
		//insertAfterWithinAllSiblings05();
		insertAfterWithinAllSiblings06();

	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
