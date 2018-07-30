package de.paloula.web.client;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import de.paloula.xml.commons.JDomXPath;

public class HTML5 {

	private Document html5Document = null;

	public HTML5(Document xmlDocument, Document xslDocument) throws TransformerException, JDOMException, IOException {
		this.html5Document = Transform.getHTML5Document(xmlDocument, xslDocument);
	}

	public String getHTML5() {
		String html5String = CleanHTML5.getCleandeHTML5(this.html5Document);

		return html5String;
	}

	public String getHTML5Part(String xPath) {
		Element partElement = JDomXPath.getFirstElement(xPath, this.html5Document);
		String html5String = CleanHTML5.getCleandeHTML5(partElement);

		return html5String;
	}

	public Document getHTML5Document() {
		return this.html5Document;
	}

}
