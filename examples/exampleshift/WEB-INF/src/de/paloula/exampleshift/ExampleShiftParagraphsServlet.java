package de.paloula.exampleshift;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.TransformerException;

import org.jdom2.Document;
import org.jdom2.JDOMException;

import de.paloula.web.client.ServletOut;
import de.paloula.xml.commons.PaloulaXmlException;

@SuppressWarnings("serial")
public class ExampleShiftParagraphsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {
			SessionContent.handleSession(session);		
			Document sessionDocument = (Document) session.getAttribute("sessionDocument");
			Document xslDocument = ShiftCommons.getXSL();
			
			ServletOut.html5Output(response, sessionDocument, xslDocument);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (PaloulaXmlException e) {
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	
}
