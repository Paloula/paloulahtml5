package de.paloula.xml.sequence;

import de.paloula.xml.commons.PaloulaXmlError;
import de.paloula.xml.commons.PaloulaXmlException;

public class ContentAttributes {
	
	private String idAttributeName = "id";
	private String positionAttributeName = "pos";
	private String validFromAttributeName = "valid-from";
	private String validToAttributeName = "valid-to";
	private String timestampAttributeName = "timestamp";
	private String activationAttributeName = "timestamp";
	private String clientLanguageAttributeName = "client-language";
	private String userRoleAttributeName = "user-role";
	private String administrationLanguageAttributeName = "admind-language";
	private int startPosSequence = 1;

	public ContentAttributes() {		
	}
	
	public String getIdAttributeName() {
		return this.idAttributeName;
	}

	public void setIdAttributeName(String idAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(idAttributeName, "id attribute name");
		this.idAttributeName = idAttributeName;
	}

	public String getPositionAttributeName() {
		return this.positionAttributeName;
	}

	public void setPositionAttributeName(String positionAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(positionAttributeName, "position attribute name");
		this.positionAttributeName = positionAttributeName;
	}

	public String getValidFromAttributeName() {
		return this.validFromAttributeName;
	}

	public void setValidFromAttributeName(String validFromAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(validFromAttributeName, "valid from attribute name");
		this.validFromAttributeName = validFromAttributeName;
	}

	public String getValidToAttributeName() {
		return this.validToAttributeName;
	}

	public void setValidToAttributeName(String validToAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(validToAttributeName, "valid to attribute name");
		this.validToAttributeName = validToAttributeName;
	}

	public String getTimestampAttributeName() {
		return this.timestampAttributeName;
	}

	public void setTimestampAttributeName(String timestampAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(timestampAttributeName, "timestamp attribute name");
		this.timestampAttributeName = timestampAttributeName;
	}

	public String getActivationAttributeName() {
		return this.activationAttributeName;
	}

	public void setActivationAttributeName(String activationAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(activationAttributeName, "activation attribute name");
		this.activationAttributeName = activationAttributeName;
	}

	public String getClientLanguageAttributeName() {
		return this.clientLanguageAttributeName;
	}

	public void setClientLanguageAttributeName(String clientLanguageAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(clientLanguageAttributeName, "client language attribute name");
		this.clientLanguageAttributeName = clientLanguageAttributeName;
	}

	public String getAdministrationLanguageAttributeName() {
		return this.administrationLanguageAttributeName;
	}

	public void setAdministrationLanguageAttributeName(String administrationLanguageAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(administrationLanguageAttributeName, "adminsitration language attribute name");
		this.administrationLanguageAttributeName = administrationLanguageAttributeName;
	}

	public String getUserRoleAttributeName() {
		return this.userRoleAttributeName;
	}

	public void setUserRoleAttributeName(String userRoleAttributeName) throws PaloulaXmlException {
		ContentAttributes.checkExceptionStringIsNullOrEmpty(userRoleAttributeName, "user rolee attribute name");
		this.userRoleAttributeName = userRoleAttributeName;
	}
	
	public int getStartPosSequence() {
		return this.startPosSequence;
	}

	public void setStartPosSequence(Integer startPosSequence) {
		this.startPosSequence = startPosSequence;
	}

	private static void checkExceptionStringIsNullOrEmpty(String testString, String role) throws PaloulaXmlException {	
		if (testString == null) {
			throw new PaloulaXmlException(PaloulaXmlError.VALUE_NULL, "com.paloula.xml.XmlAttributes", role);
		}	
		
		if (testString.length() == 0) {
			throw new PaloulaXmlException(PaloulaXmlError.VALUE_ZERO_LENGTH, "com.paloula.xml.XmlAttributes", role);
		}			
	}	
}
