package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class Sequence08InsertBeforeWithinAllSiblings {

	public static void insertBeforeWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String beforeElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertBeforeWithinAllSiblings(beforeElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet06();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String beforeElementId = "a";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertBeforeWithinAllSiblings(beforeElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet06();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String beforeElementId = "xyz";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			sequenceInsert.insertBeforeWithinAllSiblings(beforeElementId, insertElement);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element beforeElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElement +  beforeElement.getAttributes());
			sequenceInsert.insertBeforeWithinAllSiblings(beforeElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element beforeElement = JDomXPath.getFirstElement("//c[@id='xyz']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElement +  beforeElement.getAttributes());
			sequenceInsert.insertBeforeWithinAllSiblings(beforeElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertBeforeWithinAllSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element beforeElement = JDomXPath.getFirstElement("//b[@id='d']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " before " + beforeElement +  beforeElement.getAttributes());
			sequenceInsert.insertBeforeWithinAllSiblings(beforeElement, insertElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insertBeforeWithinAllSiblings01();
		insertBeforeWithinAllSiblings02();
		insertBeforeWithinAllSiblings03();
		insertBeforeWithinAllSiblings04();
		insertBeforeWithinAllSiblings05();
		insertBeforeWithinAllSiblings06();

	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
