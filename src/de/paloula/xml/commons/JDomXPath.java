package de.paloula.xml.commons;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class JDomXPath {
	
	private final static Namespace XSL_NS = Namespace.getNamespace("xsl", "http://www.w3.org/1999/XSL/Transform");

	private JDomXPath() {		
	}

	public static List<Element> getList(String xpath, Element sourceElement) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element());		
		List<Element> resultList = xpathExpression.evaluate(sourceElement);
		
		return resultList;
	}
	
	public static List<Element> getList(String xpath, Document sourceDocument) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element());		
		List<Element> resultList = xpathExpression.evaluate(sourceDocument);
		
		return resultList;
	}
	
	public static Element getFirstElement(String xpath, Document sourceDocument) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element());		
		Element resultElement = xpathExpression.evaluateFirst(sourceDocument);
		
		return resultElement; 
	}

	public static Element getFirstElement(String xpath, Element sourceElement) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element());		
		Element resultElement = xpathExpression.evaluateFirst(sourceElement);
		
		return resultElement; 
	}
	
	public static List<Element> getListXsl(String xpath, Element sourceElement) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element(), null, XSL_NS);		
		List<Element> resultList = xpathExpression.evaluate(sourceElement);
		
		return resultList;
	}
	
	public static List<Element> getListXsl(String xpath, Document sourceDocument) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element(), null, XSL_NS);		
		List<Element> resultList = xpathExpression.evaluate(sourceDocument);
		
		return resultList;
	}
	
	public static Element getFirstElementXsl(String xpath, Document sourceDocument) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element(), null, XSL_NS);		
		Element resultElement = xpathExpression.evaluateFirst(sourceDocument);
		
		return resultElement; 
	}

	public static Element getFirstElementXsl(String xpath, Element sourceElement) {
		XPathFactory xFactory = XPathFactory.instance();
		XPathExpression<Element> xpathExpression = xFactory.compile(xpath, Filters.element(), null, XSL_NS);		
		Element resultElement = xpathExpression.evaluateFirst(sourceElement);
		
		return resultElement; 
	}		
	
}
