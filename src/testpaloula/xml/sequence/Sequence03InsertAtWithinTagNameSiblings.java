package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.ContentAttributes;
import de.paloula.xml.sequence.Sequence;

public class Sequence03InsertAtWithinTagNameSiblings {

	public static void insertAtWithinTagNameSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
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
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("e", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
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
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("gg", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Parent element is null or doesn't  exist in document
	 */
	public static void insertAtWithinTagNameSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		

		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[3]", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Parent element is null or doesn't  exist in document
	 */
	public static void insertAtWithinTagNameSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		Document exampleDocument02 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		

		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument02);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Insert element without id attribute
	 */
	public static void insertAtWithinTagNameSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exception: Id of insert element already exists
	 */
	public static void insertAtWithinTagNameSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "c");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Insert element is null
	 */
	public static void insertAtWithinTagNameSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = null;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exception: Id of insert element already exists
	 */
	public static void insertAtWithinTagNameSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
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
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "1", "asdf");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	

	public static void insertAtWithinTagNameSiblings11() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet14();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Integer startPosSequenc = 0;
			ContentAttributes contentAttributes = new ContentAttributes();
			contentAttributes.setStartPosSequence(startPosSequenc);
			Sequence sequenceInsert = new Sequence(exampleDocument01, contentAttributes);
			Element parentElement = JDomXPath.getFirstElement("/*", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "1", "asdf");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		//insertAtWithinTagNameSiblings01();
		//insertAtWithinTagNameSiblings02();
		//insertAtWithinTagNameSiblings03();
		//insertAtWithinTagNameSiblings04();
		//insertAtWithinTagNameSiblings05();
		//insertAtWithinTagNameSiblings06();
		//insertAtWithinTagNameSiblings07();
		//insertAtWithinTagNameSiblings08();
		//insertAtWithinTagNameSiblings09();
		//insertAtWithinTagNameSiblings10();
		//insertAtWithinTagNameSiblings11();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
