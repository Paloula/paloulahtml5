package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence06InsertAtWithinAllSiblings {

	public static void insertAtWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAtWithinAllSiblings02() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("e", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	public static void insertAtWithinAllSiblings03() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("gg", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		

		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "x";
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "c");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = null;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertAtWithinAllSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			String siblingElementId = "c";
			Element insertElement = TestDocuments.getElement("b", "1", "asdf");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", sibling: " + siblingElementId);
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void insertAtWithinAllSiblings10() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet15();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = 0;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceInsert = new Sequence(exampleDocument01, contentAttributes);
			Element parentElement = JDomXPath.getFirstElement("/*", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "1", "asdf");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		//insertAtWithinAllSiblings01();
		//insertAtWithinAllSiblings02();
		//insertAtWithinAllSiblings03();
		//insertAtWithinAllSiblings04();
		//insertAtWithinAllSiblings05();
		//insertAtWithinAllSiblings06();
		//insertAtWithinAllSiblings07();
		//insertAtWithinAllSiblings08();
		//insertAtWithinAllSiblings09();
		insertAtWithinAllSiblings10();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
