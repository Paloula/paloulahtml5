package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class Sequence05InsertAtWithinAllSiblings {

	public static void insertAtWithinAllSiblings01() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
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
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("e", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
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
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("gg", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings04() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		

		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[3]", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings05() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		Document exampleDocument02 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument02));		

		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument02);
			Element insertElement = TestDocuments.getElement("b", "yxc");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings06() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings07() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = TestDocuments.getElement("b", "c");
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings08() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = null;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
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
	public static void insertAtWithinAllSiblings09() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
			Element insertElement = JDomXPath.getFirstElement("//b[@id='c']", exampleDocument01);;
			int targetPosition = 3;
			sequenceInsert.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
			System.out.println(JDomDocument.getStringFromElementExpand(insertElement) + " at " + targetPosition + ", parent: " + parentElement +  parentElement.getAttributes());
			System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
			printOutLine();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertAtWithinAllSiblings10() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
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

	public static void insertAtWithinAllSiblings11() {
		Document exampleDocument01 = TestDocuments.getExampleDocumet12();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		try {
			Sequence sequenceInsert = new Sequence(exampleDocument01);
			Element parentElement = JDomXPath.getFirstElement("//b[@id='a']", exampleDocument01);
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
		insertAtWithinAllSiblings01();
		insertAtWithinAllSiblings02();
		insertAtWithinAllSiblings03();
		insertAtWithinAllSiblings04();
		insertAtWithinAllSiblings05();
		insertAtWithinAllSiblings06();
		insertAtWithinAllSiblings07();
		insertAtWithinAllSiblings08();
		insertAtWithinAllSiblings09();
		insertAtWithinAllSiblings10();
		insertAtWithinAllSiblings11();
	}
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}

}
