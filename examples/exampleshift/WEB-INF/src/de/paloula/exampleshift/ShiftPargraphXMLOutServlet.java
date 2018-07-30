package de.paloula.exampleshift;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.TransformerException;

import org.jdom2.Document;
import org.jdom2.transform.XSLTransformException;

import de.paloula.web.client.ServletOut;
import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.PaloulaXmlException;

@SuppressWarnings("serial")
public class ShiftPargraphXMLOutServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {
			SessionContent.handleSession(session);
			Document sessionDocument = (Document) session.getAttribute("sessionDocument");
			ServletOut.html5Output(response, JDomDocument.getStringFromDocumentNotExpand(sessionDocument));
		} catch (XSLTransformException | IOException | TransformerException e) {
			e.printStackTrace();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
