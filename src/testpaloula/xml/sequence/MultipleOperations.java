package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;
import de.paloula.xml.sequence.SequenceDrag;

public class MultipleOperations {

	public static void multipleOperations01() throws PaloulaXmlException {
		Document exampleDocument01 = TestDocuments.getExampleDocumet09();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		Sequence sequence = new Sequence(exampleDocument01);
		
		sequence.shiftWithinTagNameSiblings("a", 4);
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
		
		Element parentElement = JDomXPath.getFirstElement("//a[@id='12345']", exampleDocument01);
		Element insertElement = TestDocuments.getElement("b", "yxc");
		sequence.insertAtWithinTagNameSiblings(parentElement, insertElement, 1);
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
		
		Element deleteOnOwnRiskElement = JDomXPath.getFirstElement("//*[@id='c']", exampleDocument01);
		deleteOnOwnRiskElement.detach();
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
		
		sequence.shiftWithinTagNameSiblings("a", 1);
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));		
		
		Element dragElement = JDomXPath.getFirstElement("//b[@id='bbb']", exampleDocument01);
		Element targetParentElement = JDomXPath.getFirstElement("//a[1]", exampleDocument01);
		SequenceDrag.copyElementWithinTagNameSiblings(sequence, dragElement, targetParentElement, 2, "newId");
		System.out.println(JDomDocument.getStringFromDocumentExpand(exampleDocument01));
		
	}
	
	
	public static void main(String[] args) {
		try {
			multipleOperations01();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void printOutLine() {
		System.out.println("==========================================");
	}
}
