package de.paloula.exampleshift;

import javax.servlet.http.HttpSession;

import org.jdom2.Document;

import de.paloula.xml.commons.PaloulaXmlException;
import de.paloula.xml.sequence.Sequence;

public class SessionContent {

	private SessionContent() {
	}

	public static void handleSession(HttpSession session) throws PaloulaXmlException {
		SessionContent.sessionDocument(session);
	}

	private static void sessionDocument(HttpSession session) throws PaloulaXmlException {
		Document sessionDocument = (Document) session.getAttribute("sessionDocument");

		if (sessionDocument == null) {
			sessionDocument = ShiftCommons.getSessionContent();
			session.setAttribute("sessionDocument", sessionDocument);

			Sequence sequence = new Sequence(sessionDocument);
			session.setAttribute("sequence", sequence);
		}
	}

	public static Integer getSessionCounter(HttpSession session) {
		Integer sessionCounter = (Integer) session.getAttribute("sessionCounter");

		if (sessionCounter == null) {
			sessionCounter = 1;
			session.setAttribute("sessionCounter", sessionCounter);
		} else {
			sessionCounter = sessionCounter + 1;
			session.setAttribute("sessionCounter", sessionCounter);
		}

		return sessionCounter;
	}

}
