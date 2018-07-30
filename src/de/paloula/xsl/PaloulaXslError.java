package de.paloula.xsl;

public enum PaloulaXslError {
	HREF_NULL(1, "Include element without href attribute."),
	DOCUMENT_NULL(2, "XSL Document is null."),
	PATH_IS_ABSOLUTE(3, "Only relative paths are allowed with includes."),
	XSL_FILE_DOESNOT_EXIST(4, "XSL File doesn't exist."),
	PATH_IS_NULL(5, "Path is null."),
	LIST_OF_PATH_IS_NULL(6, "Nullpointer list of Path");    
	   
	
    private int errorCode;
    private String errorMessage;

    private PaloulaXslError(int errorCode, String errorMessage) {
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
