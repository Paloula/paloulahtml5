package de.paloula.exampleshift;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.commons.RandomId;

public class ShiftCommons {

	public static Document getXSL() throws JDOMException, IOException, URISyntaxException {
		Path appPath = ShiftCommons.getAppPath();
		Path xslPath = appPath.resolve("ExampleShiftParagraphs.xsl");
		Document xslDocument = JDomDocument.getJDomDocument(xslPath);
		
		return xslDocument;
	}
	
	private static Path getAppPath() throws URISyntaxException {
		URI classPath = ShiftCommons.class.getProtectionDomain().getCodeSource().getLocation().toURI();
		Path appPath = Paths.get(classPath).getParent();
		appPath = appPath.resolve("app");
		
		return appPath;
	}	
	
	public static Document getSessionContent() {
		Document newDocument = JDomDocument.getEmptyDocument();
		Element root = newDocument.getRootElement();
		
		root.addContent(ShiftCommons.getElement("article", "Content A", "1", "a"));
		root.addContent(ShiftCommons.getElement("article", "Content B", "2", "b"));
		root.addContent(ShiftCommons.getElement("article", "Content C", "3", "c"));
		root.addContent(ShiftCommons.getElement("article", "Content D", "4", "d"));
		
		return newDocument;
	}
	
	public static Element getElement (String tagName, String content, String pos, String id) {
		Element newElement = new Element(tagName);
		newElement.setAttribute("pos", pos);		
		newElement.setAttribute("id", id);
		newElement.setText(content);
		
		return newElement;
	}
	
	public static Element getInsertElement(HttpSession session, Document xmlDocument) throws PaloulaXmlException {
		Integer newNumber = SessionContent.getSessionCounter(session);
		String newContent = "New Article " + newNumber;
		Element insertElement = ShiftCommons.getElement("article", newContent);
		RandomId randomId = new RandomId();
		randomId.addUniqueIdToElement(xmlDocument, insertElement);
		
		return insertElement;
	}
	
	public static Element getElement (String tagName, String content) {
		Element newElement = new Element(tagName);
		newElement.setText(content);
		
		return newElement;
	}
	
	public static int getArticlePos(HttpServletRequest request) {
		String articlePosString = request.getParameter("articlePos");
		int articlePos = Integer.parseInt(articlePosString);
		
		return articlePos;
	}
	
}
