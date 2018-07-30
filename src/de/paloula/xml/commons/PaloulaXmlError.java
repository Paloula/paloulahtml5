package de.paloula.xml.commons;

public enum PaloulaXmlError {
	ELEMENT_NULL(1, "The desired element is null."),    
	ELEMENT_HAS_NO_ID(2, "Element without id attribute in sequence."),
	ELEMENT_HAS_NO_POSITION(3, "Element without position attribute."),
	NOT_SAME_PARENTS(4, "Elements have not the same parents."),
	UNEQUAL_TAGNAMES(5, "Elements have not the same tagname."),
	SAME_ELEMENTS(6, "Shift and target element are the same."),
	DOUBLE_ELEMENTS(7, "Two ore more Elements with the same id."),
	ELEMENT_DOESNT_EXIST(8, "Elements doesn't exist."),
	DOCUMENT_NULL(9, "XML Document is null."),
	VALUE_NULL(10, "Value is null."),
	VALUE_ZERO_LENGTH(11, "Zerolength"),
	CONTENT_ATTRIBUTE_NAMES_NULL(12, "ContentAttributeNames is null."),
	SEQUENCE_NULL(1, "Sequence is null.");   
	
    private int errorCode;
    private String errorMessage;

    private PaloulaXmlError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
	

}
