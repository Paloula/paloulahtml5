package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class Sequence04InsertAtWithinTagNameSiblings {

	public static void insertAtWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAtWithinTagNameSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("e", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAtWithinTagNameSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("gg", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Exception: No sibling element with given id
	 */
	public static void insertAtWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		

		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "x";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Exception: Insert element has no id
	 */
	public static void insertAtWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Id of insert element already exists
	 */
	public static void insertAtWithinTagNameSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "c");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Insert element is null
	 */
	public static void insertAtWithinTagNameSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = null;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Id of insert element already exists
	 */
	public static void insertAtWithinTagNameSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertAtWithinTagNameSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "1", "asdf");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void insertAtWithinTagNameSiblings10() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "xyz";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 1;
			sequenceInsert.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		insertAtWithinTagNameSiblings01();
		//insertAtWithinTagNameSiblings02();
		//insertAtWithinTagNameSiblings03();
		//insertAtWithinTagNameSiblings04();
		//insertAtWithinTagNameSiblings05();
		//insertAtWithinTagNameSiblings06();
		//insertAtWithinTagNameSiblings07();
		//insertAtWithinTagNameSiblings08();
		//insertAtWithinTagNameSiblings09();
		//insertAtWithinTagNameSiblings10();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
