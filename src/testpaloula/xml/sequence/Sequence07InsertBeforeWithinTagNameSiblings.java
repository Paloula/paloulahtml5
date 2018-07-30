package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class Sequence07InsertBeforeWithinTagNameSiblings {

	public static void insertBeforeWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String beforeElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertBeforeWithinTagNameSiblings(beforeElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet02();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String beforeElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertBeforeWithinTagNameSiblings(beforeElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Insert and before element have unequal tagnames
	 */
	public static void insertBeforeWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet02();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String beforeElementId = "xyz";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertBeforeWithinTagNameSiblings(beforeElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element beforeElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElement +  beforeElement.getAttributes());
			sequenceInsert.insertBeforeWithinTagNameSiblings(beforeElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Insert and before element have unequal tagnames
	 */
	public static void insertBeforeWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element beforeElement = JDomXPath.getFirstElement("//c[@id='xyz']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElement +  beforeElement.getAttributes());
			sequenceInsert.insertBeforeWithinTagNameSiblings(beforeElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinTagNameSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element beforeElement = JDomXPath.getFirstElement("//b[@id='d']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElement +  beforeElement.getAttributes());
			sequenceInsert.insertBeforeWithinTagNameSiblings(beforeElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insertBeforeWithinTagNameSiblings01();
		//insertBeforeWithinTagNameSiblings02();
		//insertBeforeWithinTagNameSiblings03();
		//insertBeforeWithinTagNameSiblings04();
		//insertBeforeWithinTagNameSiblings05();
		//insertBeforeWithinTagNameSiblings06();

	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
