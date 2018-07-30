package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class Sequence09InsertAferWithinTagNameSiblings {

	public static void insertAfterWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String afterElementId = "a";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertAfterWithinTagNameSiblings(afterElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet02();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String afterElementId = "d";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertAfterWithinTagNameSiblings(afterElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Insert and after element have unequal tagnames
	 */
	public static void insertAfterWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet02();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String afterElementId = "xyz";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertAfterWithinTagNameSiblings(afterElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element afterElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElement +  afterElement.getAttributes());
			sequenceInsert.insertAfterWithinTagNameSiblings(afterElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Insert and after element have unequal tagnames
	 */
	public static void insertAfterWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element afterElement = JDomXPath.getFirstElement("//c[@id='xyz']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElement +  afterElement.getAttributes());
			sequenceInsert.insertAfterWithinTagNameSiblings(afterElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAfterWithinTagNameSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element afterElement = JDomXPath.getFirstElement("//b[@id='d']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " after " + afterElement +  afterElement.getAttributes());
			sequenceInsert.insertAfterWithinTagNameSiblings(afterElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//insertAfterWithinTagNameSiblings01();
		insertAfterWithinTagNameSiblings02();
		//insertAfterWithinTagNameSiblings03();
		//insertAfterWithinTagNameSiblings04();
		//insertAfterWithinTagNameSiblings05();
		//insertAfterWithinTagNameSiblings06();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
