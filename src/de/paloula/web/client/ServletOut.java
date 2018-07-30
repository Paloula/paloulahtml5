package de.paloula.web.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.transform.XSLTransformException;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServletOut {

	private ServletOut() {
	}

	public static void html5Output(HttpServletResponse response, Document outputXMLDocument, Document outputXSLDocument) throws TransformerException, IOException, JDOMException {
		ServletOut.setHeaderHTML(response);
		ServletOut.setResponseOK(response);
		HTML5 html5 = new HTML5(outputXMLDocument, outputXSLDocument);
		String html5Out = html5.getHTML5();
		ServletOut.printOut(response, html5Out);
	}

	public static void html5Output(HttpServletResponse response, String html5Out) throws IOException, XSLTransformException, TransformerException {
		ServletOut.setHeaderHTML(response);
		ServletOut.setResponseOK(response);
		ServletOut.printOut(response, html5Out);
	}

	public static void html5Output(HttpServletResponse response, Document outputXMLDocument, Document outputXSLDocument, String xPath) throws IOException, TransformerException, JDOMException {
		ServletOut.setHeaderHTML(response);
		ServletOut.setResponseOK(response);
		HTML5 html5 = new HTML5(outputXMLDocument, outputXSLDocument);
		String html5Out = html5.getHTML5Part(xPath);
		ServletOut.printOut(response, html5Out);
	}

	public static void ajaxJSONOutput(HttpServletResponse response, JSONObject ajaxResult) throws IOException {
		ServletOut.setHeaderJSON(response);
		ServletOut.setResponseOK(response);
		ServletOut.printOut(response, ajaxResult.toString());
	}

	public static void ajaxJSONOutput(HttpServletResponse response, JSONArray ajaxResult) throws IOException {
		ServletOut.setHeaderJSON(response);
		ServletOut.setResponseOK(response);
		ServletOut.printOut(response, ajaxResult.toString());
	}

	public static void redirectPage(HttpServletResponse response, String redirectUrl) throws IOException {
		ServletOut.setHeaderHTML(response);
		response.setHeader("Location", redirectUrl);
		response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
		response.sendRedirect(redirectUrl);
	}

	public static void redirectAjax(HttpServletResponse response, String redirectUrl) throws IOException {
		ServletOut.setHeaderJSON(response);
		ServletOut.setResponseOK(response);
		JSONObject redirectJSON = new JSONObject();
		redirectJSON.put("url", redirectUrl);
		ServletOut.printOut(response, redirectJSON.toString());
	}
	
	public static void bufferedStreamOutput(HttpServletResponse response, String filePath, String HeaderContentDisposition, String ContentType) throws IOException {
		File outStreamFile = new File(filePath);
		int contentLength = (int) outStreamFile.length();
		ServletOut.setResponseHeaderData(response, HeaderContentDisposition, ContentType, contentLength);

		FileInputStream fileStream = new FileInputStream(outStreamFile);
		OutputStream outStream = response.getOutputStream();
		int outBufferSize = response.getBufferSize();

		byte[] buf = new byte[outBufferSize];
		int count = 0;

		while ((count = fileStream.read(buf)) >= 0) {
			outStream.write(buf, 0, count);
		}

		fileStream.close();
		outStream.close();
	}

	private static void setResponseHeaderData(HttpServletResponse response, String HeaderContentDisposition, String ContentType, int contentLength) {
		response.setHeader("Content-Disposition", HeaderContentDisposition);
		response.setContentType(ContentType);
		response.setContentLength(contentLength);
	}
	
	private static void setHeaderHTML(HttpServletResponse response) {
		response.setHeader("Content-Type", "text/html");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	private static void setHeaderJSON(HttpServletResponse response) {
		response.setHeader("Content-Type", "text/json");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	
	private static void setResponseOK (HttpServletResponse response) {		
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	private static void printOut(HttpServletResponse response, String print) throws IOException {
		PrintWriter clientOut = response.getWriter();
		clientOut.print(print);
		clientOut.flush();
		clientOut.close();
	}
}
