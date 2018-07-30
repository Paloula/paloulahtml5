package de.paloula.xml.sequence;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.xpath.XPathHelper;

import de.paloula.xml.commons.JDomXPath;
import de.paloula.xml.commons.PaloulaXmlError;
import de.paloula.xml.commons.PaloulaXmlException;

public class SequenceCheckExceptions {

	private SequenceCheckExceptions() {		
	}

	public static void checkExceptionElementsUnequalTagName(Element testElement1, Element testElement2) throws PaloulaXmlException {
		String testElement1TagName = testElement1.getName();
		String testElement2TagName = testElement2.getName();
		
		if (!testElement1TagName.equals(testElement2TagName)) {
			throw new PaloulaXmlException(PaloulaXmlError.UNEQUAL_TAGNAMES, "com.paloula.xml.SequenceDocument", testElement1TagName + ", " + testElement2TagName);
		}
	}
	
	public static void checkExceptionSequenceElementPositionMissing(Element testElement, String posAttributeName, String testElementId) throws PaloulaXmlException {
		String testElementPosition = testElement.getAttributeValue(posAttributeName);
		
		if (testElementPosition == null) {
			throw new PaloulaXmlException(PaloulaXmlError.ELEMENT_HAS_NO_POSITION, "com.paloula.xml.SequenceDocument", "Element id: " + testElementId + ", position attribute name: " + posAttributeName);
		}		
	}		
	
	public static void checkExceptionSequenceElementIdMissing(Element testElement, String idAttributeName) throws PaloulaXmlException {
		String testElementId = testElement.getAttributeValue(idAttributeName);
		
		if (testElementId == null) {
			throw new PaloulaXmlException(PaloulaXmlError.ELEMENT_HAS_NO_ID, "com.paloula.xml.SequenceDocument", "Id attribute name: " + idAttributeName);
		}		
	}
	
	public static void checkExceptionContentAttributesIsNull(ContentAttributes contentAttributeNames) throws PaloulaXmlException {	
		if (contentAttributeNames == null) {
			throw new PaloulaXmlException(PaloulaXmlError.CONTENT_ATTRIBUTE_NAMES_NULL, "com.paloula.xml.SequenceDocument", "");
		}
	}	

	public static void checkExceptionSequenceIsNull(Sequence sequence) throws PaloulaXmlException {	
		if (sequence == null) {
			throw new PaloulaXmlException(PaloulaXmlError.SEQUENCE_NULL, "com.paloula.xml.SequenceDocument", "");
		}
	}	

	public static void checkExceptionDocumentIsNull(Document testDocument) throws PaloulaXmlException {	
		if (testDocument == null) {
			throw new PaloulaXmlException(PaloulaXmlError.DOCUMENT_NULL, "com.paloula.xml.SequenceDocument", "Document: " + testDocument);
		}
	}

	public static void checkExceptionStringIsNullOrEmpty(String testString, String role) throws PaloulaXmlException {	
		if (testString == null) {
			throw new PaloulaXmlException(PaloulaXmlError.VALUE_NULL, "com.paloula.xml.SequenceDocument", role);
		}	
		
		if (testString.length() == 0) {
			throw new PaloulaXmlException(PaloulaXmlError.VALUE_ZERO_LENGTH, "com.paloula.xml.SequenceDocument", role);
		}			
	}
	
	public static void checkExceptionElementNull(Element testElement, String role) throws PaloulaXmlException {
		if (testElement == null) {
			throw new PaloulaXmlException(PaloulaXmlError.ELEMENT_NULL, "com.paloula.xml.SequenceDocument", role);
		}		
	}
	
	public static void checkExceptionElementNull(Element testElement, String idAttributeName, String testtElementId) throws PaloulaXmlException {
		if (testElement == null) {
			throw new PaloulaXmlException(PaloulaXmlError.ELEMENT_NULL, "com.paloula.xml.SequenceDocument", "Element with " + idAttributeName + ": " + testtElementId);
		}		
	}	
	
	public static void checkExceptionIdAlreadyExists(Document testDocument, String idAttributeName, Element targetElement) throws PaloulaXmlException {
		String targetElementId = targetElement.getAttributeValue(idAttributeName);
		String xpathTargetElement = "//*[@" + idAttributeName + "='" + targetElementId + "']";
		List<Element> targetElementList = JDomXPath.getList(xpathTargetElement, testDocument);		
		
		if (targetElementList.size() > 0) {
			throw new PaloulaXmlException(PaloulaXmlError.DOUBLE_ELEMENTS, "com.paloula.xml.SequenceDocument", "Elements with " + idAttributeName + ": " + targetElementId);
		}
	}		

	public static void checkExceptionElementExistsInDocument(Document testDocument, Element testElement) throws PaloulaXmlException {
		String testElementXPath = XPathHelper.getAbsolutePath(testElement);
		Element compareElement = JDomXPath.getFirstElement(testElementXPath, testDocument);
		
		if (testElementXPath == null) {
			throw new PaloulaXmlException(PaloulaXmlError.ELEMENT_DOESNT_EXIST, "com.paloula.xml.SequenceDocument", "Element: " + testElement + " XPath: " + testElementXPath);
		}
		
		if (compareElement != testElement) {
			throw new PaloulaXmlException(PaloulaXmlError.ELEMENT_DOESNT_EXIST, "com.paloula.xml.SequenceDocument", "Element: " + testElement + " XPath: " + testElementXPath);
		}		
	}		
}
