package de.paloula.web.client;

import java.io.IOException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.transform.JDOMResult;
import org.jdom2.transform.JDOMSource;

public class Transform {
	
	private Transform() {		
	}
	
	public static Document getHTML5Document(Document xmlDocument, Document xslDocument) throws TransformerException, JDOMException, IOException {
		JDOMSource xmlSource = new JDOMSource(xmlDocument);
		JDOMSource xslSource = new JDOMSource(xslDocument);
		JDOMResult jdomResult = new JDOMResult();

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(xslSource);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.transform(xmlSource, jdomResult);

		Document html5Document = jdomResult.getDocument();

		return html5Document;
	}
}
