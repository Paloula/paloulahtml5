package de.paloula.xml.commons;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;

import org.jdom2.Document;
import org.jdom2.Element;

import com.sun.istack.internal.NotNull;

import de.paloula.xml.sequence.SequenceCheckExceptions;

public class RandomId {

	private static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom secureRandom = new SecureRandom();	
	
	private String idAttributeName = "id";
	private int idLength = 30;
	
	public RandomId() {		
	}
	
	public RandomId(String idAttributeName) {	
		this.idAttributeName = idAttributeName;
	}
	
	public RandomId(int idLength) {	
		this.idLength = idLength;
	}

	public RandomId(String idAttributeName, int idLength) {	
		this.idAttributeName = idAttributeName;
		this.idLength = idLength;
	}

	public void addUniqueIdToElement(@NotNull Document testDocument, @NotNull Element idElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionDocumentIsNull(testDocument);
		SequenceCheckExceptions.checkExceptionElementNull(idElement, "Id element.");
		
		String testId = this.getRandomAlphanumeric();
		String testXPath = "//*[@" + this.idAttributeName + " = '" + testId + "']";
		Element compareElement = JDomXPath.getFirstElement(testXPath, testDocument);
		
		while (compareElement != null) {
			testId = this.getRandomAlphanumeric();
			testXPath = "//*[@" + this.idAttributeName + " = '" + testId + "]";
			compareElement = JDomXPath.getFirstElement(testXPath, testDocument);
		}
		
		idElement.setAttribute(this.idAttributeName, testId);		
	}
	
	public void addUniqueIdToElementSmallCaps(@NotNull Document testDocument, @NotNull Element idElement) {
		
	}
	
	// Prefix
	// Suffix
	// Starts with char
	
	// Timestamp separate??
	public void addUniqueIdAndTimestampIdToElement(@NotNull Document testDocument, @NotNull Element idElement) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionElementNull(idElement, "Id element.");
		long sysDate = getSysDateLong();
		idElement.setAttribute("timestamp", sysDate + "");
		
		this.addUniqueIdToElement(testDocument, idElement);
	}	
	
	private String getRandomAlphanumeric() {
		StringBuilder randomString = new StringBuilder(this.idLength);
		
		for (int i = 0; i < this.idLength; i++) {
			randomString.append(ALPHANUMERIC.charAt(secureRandom.nextInt(ALPHANUMERIC.length())));
		}
		
		return randomString.toString();
	}	
	
	private static long getSysDateLong() {
		Calendar cal = Calendar.getInstance(); 
		Date date = new Date();
	    cal.setTime(date);
	    long resultDateLong = cal.getTimeInMillis();
    
	    return resultDateLong;
	}	
}
