package de.paloula.web.client;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;

import de.paloula.xml.commons.JDomDocument;
import de.paloula.xml.commons.JDomXPath;

public class CleanHTML5 {

	private CleanHTML5() {
	}

	public static String getCleandeHTML5(Document html5Document) {
		CleanHTML5.setDocType(html5Document);
		CleanHTML5.elementNamesToLowerCase(html5Document);
		String html5 = JDomDocument.getStringFromDocumentNotExpand(html5Document);
		html5 = CleanHTML5.getCleanedXHTML5(html5);

		return html5;
	}

	public static String getCleandeHTML5(Element html5Element) {
		CleanHTML5.elementNamesToLowerCase(html5Element);
		String html5 = JDomDocument.getStringFromElementNotExpand(html5Element);
		html5 = CleanHTML5.getCleanedXHTML5(html5);

		return html5;
	}

	private static void setDocType(Document html5Document) {
		DocType docType = new DocType("html");
		html5Document.setDocType(docType);
	}

	private static void elementNamesToLowerCase(Document html5Document) {
		List<Element> allElements = JDomXPath.getList("//*", html5Document);
		CleanHTML5.elementNamesToLowerCase(allElements);
	}

	private static void elementNamesToLowerCase(Element html5Element) {
		List<Element> allElements = JDomXPath.getList("//*", html5Element);
		CleanHTML5.elementNamesToLowerCase(allElements);
	}
	
	private static void elementNamesToLowerCase(List<Element> allElements) {
		for (Element element : allElements) {
			element.setName(element.getName().toLowerCase());
		}
	}

	private static String getCleanedXHTML5(String html5) {
		List<String> html5Elements = CleanHTML5.getHTML5Elements();

		for (String html5Element : html5Elements) {
			html5 = CleanHTML5.formatSelfclosingElements(html5, html5Element);
		}

		html5 = CleanHTML5.replaceSpaceBeforeTagend(html5);

		return html5;
	}

	private static List<String> getHTML5Elements() {
		List<String> html5Elements = new ArrayList<String>();

		html5Elements.add("script");
		html5Elements.add("div");
		html5Elements.add("br");
		html5Elements.add("style");
		html5Elements.add("noscript");
		html5Elements.add("section");
		html5Elements.add("nav");
		html5Elements.add("aside");
		html5Elements.add("article");
		html5Elements.add("header");
		html5Elements.add("footer");
		html5Elements.add("address");
		html5Elements.add("figcaption");
		html5Elements.add("figure");
		html5Elements.add("dd");
		html5Elements.add("dt");
		html5Elements.add("dl");
		html5Elements.add("li");
		html5Elements.add("ul");
		html5Elements.add("ol");
		html5Elements.add("blockquote");
		html5Elements.add("pre");
		html5Elements.add("p");
		html5Elements.add("sub");
		html5Elements.add("kbd");
		html5Elements.add("samp");
		html5Elements.add("var");
		html5Elements.add("code");
		html5Elements.add("time");
		html5Elements.add("data");
		html5Elements.add("abbr");
		html5Elements.add("dfn");
		html5Elements.add("q");
		html5Elements.add("cite");
		html5Elements.add("s");
		html5Elements.add("small");
		html5Elements.add("strong");
		html5Elements.add("em");
		html5Elements.add("a");
		html5Elements.add("span");
		html5Elements.add("bdo");
		html5Elements.add("bdi");
		html5Elements.add("rp");
		html5Elements.add("ruby");
		html5Elements.add("mark");
		html5Elements.add("u");
		html5Elements.add("b");
		html5Elements.add("i");
		html5Elements.add("math");
		html5Elements.add("svg");
		html5Elements.add("map");
		html5Elements.add("canvas");
		html5Elements.add("audio");
		html5Elements.add("video");
		html5Elements.add("object");
		html5Elements.add("embed");
		html5Elements.add("iframe");
		html5Elements.add("del");
		html5Elements.add("ins");
		html5Elements.add("th");
		html5Elements.add("td");
		html5Elements.add("tr");
		html5Elements.add("tfoot");
		html5Elements.add("thead");
		html5Elements.add("tbody");
		html5Elements.add("col");
		html5Elements.add("colgroup");
		html5Elements.add("caption");
		html5Elements.add("table");
		html5Elements.add("meter");
		html5Elements.add("progress");
		html5Elements.add("output");
		html5Elements.add("keygen");
		html5Elements.add("textarea");
		html5Elements.add("option");
		html5Elements.add("optgroup");
		html5Elements.add("datalist");
		html5Elements.add("select");
		html5Elements.add("button");
		html5Elements.add("label");
		html5Elements.add("legend");
		html5Elements.add("fieldset");
		html5Elements.add("form");
		html5Elements.add("menu");
		html5Elements.add("command");
		html5Elements.add("summary");
		html5Elements.add("details");

		return html5Elements;
	}

	private static String formatSelfclosingElements(String xmlAsString, String tagName) {
		String result = xmlAsString;
		Pattern patt = Pattern.compile("(<\\b" + tagName + "\\b[^>]*)(\\s*/>)");
		Matcher mattcher = patt.matcher(xmlAsString);

		while (mattcher.find()) {
			result = mattcher.replaceAll("$1></" + tagName + ">");
		}

		return result;
	}

	private static String replaceSpaceBeforeTagend(String html5) {
		html5 = html5.replaceAll(" >", ">");
		html5 = html5.replaceAll(" />", "/>");

		return html5;
	}
}
