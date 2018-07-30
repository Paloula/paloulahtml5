package testpaloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

import de.paloula.xml.commons.JDomDocument;

public class TestDocuments {
	
	public static Document getExampleDocumet01() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "1", "a"));
		root.addContent(TestDocuments.getElement("b", "2", "b"));
		root.addContent(TestDocuments.getElement("b", "3", "c"));
		root.addContent(TestDocuments.getElement("b", "4", "d"));
		root.addContent(TestDocuments.getElement("c", "1", "xyz"));
		
		return newDocument;
	}

	public static Document getExampleDocumet02() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "1", "a"));
		root.addContent(TestDocuments.getElement("b", "3", "b"));
		root.addContent(TestDocuments.getElement("b", "4", "c"));
		root.addContent(TestDocuments.getElement("b", "6", "d"));
		root.addContent(TestDocuments.getElement("c", "1", "xyz"));
		
		return newDocument;
	}
	
	public static Document getExampleDocumet03() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "1", "a"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "2", "b"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "3", "c"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "4", "d"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("c", "1", "xyz"));
		
		return newDocument;
	}

	public static Document getExampleDocumet04() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "-2", "a"));
		root.addContent(TestDocuments.getElement("b", "-1", "b"));
		root.addContent(TestDocuments.getElement("b", "0", "c"));
		root.addContent(TestDocuments.getElement("b", "1", "d"));
		root.addContent(TestDocuments.getElement("c", "-2", "xyz"));
		
		return newDocument;
	}	
	
	public static Document getExampleDocumet05() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "1", "a"));
		root.addContent(TestDocuments.getElement("b", "2", "b"));
		root.addContent(TestDocuments.getElement("b", "3", "c"));
		root.addContent(TestDocuments.getElement("b", "4", "d"));
		root.addContent(TestDocuments.getElement("c", "5", "xyz"));
		
		return newDocument;
	}

	public static Document getExampleDocumet06() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "1", "a"));
		root.addContent(TestDocuments.getElement("b", "3", "b"));
		root.addContent(TestDocuments.getElement("b", "4", "c"));
		root.addContent(TestDocuments.getElement("b", "6", "d"));
		root.addContent(TestDocuments.getElement("c", "8", "xyz"));
		
		return newDocument;
	}
	
	public static Document getExampleDocumet07() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "1", "a"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "2", "b"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "3", "c"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("b", "4", "d"));
		root.addContent(TestDocuments.getElementDifferentAttributeNames("c", "5", "xyz"));
		
		return newDocument;
	}

	public static Document getExampleDocumet08() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "-2", "a"));
		root.addContent(TestDocuments.getElement("b", "-1", "b"));
		root.addContent(TestDocuments.getElement("b", "0", "c"));
		root.addContent(TestDocuments.getElement("b", "1", "d"));
		root.addContent(TestDocuments.getElement("c", "2", "xyz"));
		
		return newDocument;
	}	
	
	public static Document getExampleDocumet09() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		Element a1 = TestDocuments.getElement("a", "12345");				
		a1.addContent(TestDocuments.getElement("b", "1", "a"));
		a1.addContent(TestDocuments.getElement("b", "2", "b"));
		a1.addContent(TestDocuments.getElement("b", "3", "c"));
		a1.addContent(TestDocuments.getElement("b", "4", "d"));
		a1.addContent(TestDocuments.getElement("e", "1", "xyz"));
		root.addContent(a1);

		Element a2 = TestDocuments.getElement("a");				
		a2.addContent(TestDocuments.getElement("b", "1", "aaa"));
		a2.addContent(TestDocuments.getElement("b", "2", "bbb"));
		root.addContent(a2);
		
		return newDocument;
	}	
	
	public static Document getExampleDocumet10() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "1", "a"));
		root.addContent(TestDocuments.getElement("b", "2", "b"));
		root.addContent(TestDocuments.getElement("b", "c"));
		root.addContent(TestDocuments.getElement("b", "4", "d"));
		root.addContent(TestDocuments.getElement("c", "1", "xyz"));
		
		return newDocument;
	}

	public static Document getExampleDocumet11() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "1", "a"));
		root.addContent(TestDocuments.getElement("b", "2", "b"));
		root.addContent(TestDocuments.getElement("b", 3));
		root.addContent(TestDocuments.getElement("b", "4", "d"));
		root.addContent(TestDocuments.getElement("c", "1", "xyz"));
		
		return newDocument;
	}

	public static Document getExampleDocumet12() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		Element a1 = TestDocuments.getElement("a", "12345");				
		a1.addContent(TestDocuments.getElement("b", "1", "a"));
		a1.addContent(TestDocuments.getElement("b", "2", "b"));
		a1.addContent(TestDocuments.getElement("b", "3", "c"));
		a1.addContent(TestDocuments.getElement("b", "4", "d"));
		a1.addContent(TestDocuments.getElement("e", "5", "xyz"));
		root.addContent(a1);

		Element a2 = TestDocuments.getElement("a");				
		a2.addContent(TestDocuments.getElement("b", "1", "aaa"));
		a2.addContent(TestDocuments.getElement("b", "2", "bbb"));
		root.addContent(a2);
		
		return newDocument;
	}		

	public static Document getExampleDocumet13() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "0", "a"));
		root.addContent(TestDocuments.getElement("b", "3", "b"));
		root.addContent(TestDocuments.getElement("b", "4", "c"));
		root.addContent(TestDocuments.getElement("b", "6", "d"));
		root.addContent(TestDocuments.getElement("c", "1", "xyz"));
		
		return newDocument;
	}
	
	public static Document getExampleDocumet14() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "0", "a"));
		root.addContent(TestDocuments.getElement("b", "1", "b"));
		root.addContent(TestDocuments.getElement("b", "2", "c"));
		root.addContent(TestDocuments.getElement("b", "3", "d"));
		root.addContent(TestDocuments.getElement("c", "1", "xyz"));
		
		return newDocument;
	}	
	
	public static Document getExampleDocumet15() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "0", "a"));
		root.addContent(TestDocuments.getElement("b", "1", "b"));
		root.addContent(TestDocuments.getElement("b", "2", "c"));
		root.addContent(TestDocuments.getElement("b", "3", "d"));
		root.addContent(TestDocuments.getElement("c", "4", "xyz"));
		
		return newDocument;
	}	

	public static Document getExampleDocumet16() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(TestDocuments.getElement("b", "0", "a1"));
		root.addContent(TestDocuments.getElement("b", "1", "b2"));
		root.addContent(TestDocuments.getElement("b", "2", "c3"));
		root.addContent(TestDocuments.getElement("b", "3", "d4"));
		root.addContent(TestDocuments.getElement("c", "4", "xyz"));
		
		return newDocument;
	}	

	public static Element getElement (String tagName, String pos, String id) {
		Element newElement = new Element(tagName);
		newElement.setAttribute("pos", pos);		
		newElement.setAttribute("id", id);
		newElement.setText(id.toUpperCase());
		
		return newElement;
	}
	
	private static Element getElementDifferentAttributeNames (String tagName, String pos, String id) {
		Element newElement = new Element(tagName);
		newElement.setAttribute("position", pos);		
		newElement.setAttribute("identity", id);
		newElement.setText(id.toUpperCase());
		
		return newElement;
	}

	private static Element getElementXSL (String tagName, String pos, String id) {
		Namespace xslNS = Namespace.getNamespace("xsl", "http://www.w3.org/1999/XSL/Transform");
		Element newElement = new Element(tagName, xslNS);
		newElement.setAttribute("pos", pos);		
		newElement.setAttribute("id", id);
		
		return newElement;
	}	
	
	public static Element getElement (String tagName, String id) {
		Element newElement = new Element(tagName);
		newElement.setAttribute("id", id);
		
		return newElement;
	}
	
	public static Element getElement (String tagName, int pos) {
		Element newElement = new Element(tagName);
		newElement.setAttribute("pos", pos + "");
		
		return newElement;
	}

	public static Element getElement (String tagName) {
		Element newElement = new Element(tagName);
		
		return newElement;
	}

}
