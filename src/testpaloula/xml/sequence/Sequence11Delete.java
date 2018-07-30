package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence11Delete {

	public static void deleteWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			String elementId = "b";
			sequenceDelete.deleteWithinTagNameSiblings(elementId);
			System.out.println("delete:" + elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Delete element null
	 */
	public static void deleteWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			String elementId = "stu";
			System.out.println("delete:" + elementId);
			sequenceDelete.deleteWithinTagNameSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			Element deleteElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			sequenceDelete.deleteWithinTagNameSiblings(deleteElement);
			System.out.println("delete:" + deleteElement + deleteElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Delete element null
	 */
	public static void deleteWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet01();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			Element deleteElement = JDomXPath.getFirstElement("//b[@id='ttt']", exampleDocument01);
			System.out.println("delete:" + deleteElement);
			sequenceDelete.deleteWithinTagNameSiblings(deleteElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void deleteWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			String elementId = "b";
			sequenceDelete.deleteWithinAllSiblings(elementId);
			System.out.println("delete:" + elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Delete element null
	 */
	public static void deleteWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			String elementId = "stu";
			System.out.println("delete:" + elementId);
			sequenceDelete.deleteWithinAllSiblings(elementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			Element deleteElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			sequenceDelete.deleteWithinAllSiblings(deleteElement);
			System.out.println("delete:" + deleteElement + deleteElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Delete element null
	 */
	public static void deleteWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet05();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceDelete = new Sequence(exampleDocument01);
			Element deleteElement = JDomXPath.getFirstElement("//b[@id='ttt']", exampleDocument01);
			System.out.println("delete:" + deleteElement);
			sequenceDelete.deleteWithinAllSiblings(deleteElement);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet15();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = 0;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceDelete = new Sequence(exampleDocument01, contentAttributes);
			Element deleteElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
			sequenceDelete.deleteWithinAllSiblings(deleteElement);
			System.out.println("delete:" + deleteElement + deleteElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		deleteWithinTagNameSiblings01();
		//deleteWithinTagNameSiblings02();
		//deleteWithinTagNameSiblings03();
		//deleteWithinTagNameSiblings04();
		//deleteWithinAllSiblings01();
		//deleteWithinAllSiblings02();
		//deleteWithinAllSiblings03();
		//deleteWithinAllSiblings04();	
		//deleteWithinAllSiblings05();	
	}
	
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
