package de.paloula.xsl;


@SuppressWarnings("serial")
public class PaloulaXslException extends Exception  {
    private PaloulaXslError xslError;
    private String information = "";
    private String className = "";

    public PaloulaXslException(PaloulaXslError businessProcessError) {
        this.xslError = businessProcessError;
    }

    public PaloulaXslException(PaloulaXslError businessProcessError, String className, String information) {
        this.xslError = businessProcessError;
        this.information = information;
        this.className = className;
    }

    public PaloulaXslException(PaloulaXslError businessProcessError, Exception cause) {
        super(cause);

        this.xslError = businessProcessError;
    }

    public PaloulaXslError getMailError() {
        return xslError;
    }

    @Override
    public String getMessage() {
        return "[" + String.format("%4s", xslError.getErrorCode()).replace(" ", "0") + "] " + "[" + this.className + "] " + xslError.getErrorMessage() + " " + this.information;
    }
}
