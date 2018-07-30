package de.paloula.xml.commons;



@SuppressWarnings("serial")
public class PaloulaXmlException extends Exception  {
    private PaloulaXmlError xmlError;
    private String information = "";
    private String className = "";

    public PaloulaXmlException(PaloulaXmlError businessProcessError) {
        this.xmlError = businessProcessError;
    }

    public PaloulaXmlException(PaloulaXmlError businessProcessError, String className, String information) {
        this.xmlError = businessProcessError;
        this.information = information;
        this.className = className;
    }

    public PaloulaXmlException(PaloulaXmlError businessProcessError, Exception cause) {
        super(cause);

        this.xmlError = businessProcessError;
    }

    public PaloulaXmlError getMailError() {
        return xmlError;
    }

    @Override
    public String getMessage() {
        return "[" + String.format("%4s", xmlError.getErrorCode()).replace(" ", "0") + "] " + "[" + this.className + "] " + xmlError.getErrorMessage() + " " + this.information;
    }
}
