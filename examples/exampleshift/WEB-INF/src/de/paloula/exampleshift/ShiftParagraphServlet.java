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
import org.jdom2.Element;
import org.jdom2.JDOMException;

import de.paloula.web.client.ServletOut;
import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

@SuppressWarnings("serial")
public class ShiftParagraphServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		ShiftParagraphServlet.redirectOnNewSession(request, response);		
		HttpSession session = request.getSession();

		
		try {
			SessionContent.handleSession(session);

			Sequence sequence = (Sequence) session.getAttribute("sequence");
			Document xmlDocument = sequence.getXmlDocument();
			String articleId = request.getParameter("articleId");
			String shiftCommand = request.getParameter("shiftCommand");

			if (shiftCommand.equals("shiftUp")) {
				sequence.shiftPreviousWithinTagNameSiblings(articleId);
			} else if (shiftCommand.equals("shiftDown")) {
				sequence.shiftNextWithinTagNameSiblings(articleId);
			} else if (shiftCommand.equals("delete")) {
				sequence.deleteWithinTagNameSiblings(articleId);
			} else if (shiftCommand.equals("insertBefore")) {
				Element insertElement = ShiftCommons.getInsertElement(session, xmlDocument);
				sequence.insertBeforeWithinTagNameSiblings(articleId, insertElement);
			} else if (shiftCommand.equals("insertAfter")) {
				Element insertElement = ShiftCommons.getInsertElement(session, xmlDocument);
				sequence.insertAfterWithinTagNameSiblings(articleId, insertElement);
			} else if (shiftCommand.equals("insertNewEmpty")) {
				Element insertElement = ShiftCommons.getInsertElement(session, xmlDocument);
				Element parentElement = xmlDocument.getRootElement();
				sequence.insertAtWithinAllSiblings(parentElement, insertElement, 1);
			}			

			Document xslDocument = ShiftCommons.getXSL();
			ServletOut.html5Output(response, xmlDocument, xslDocument, "//*[@data-part='2']");

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
			try {
				String sn = request.getServerName();
				String cp = request.getContextPath();
				String redirectUrl = "http://" + sn + cp + "/index.html";
				ServletOut.redirectAjax(response, redirectUrl);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private static void redirectOnNewSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		if (session == null || session.isNew()) {
			String sn = request.getServerName();
			String cp = request.getContextPath();
			String redirectUrl = "http://" + sn + cp + "/index.html";
			
			try {
				ServletOut.redirectAjax(response, redirectUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
