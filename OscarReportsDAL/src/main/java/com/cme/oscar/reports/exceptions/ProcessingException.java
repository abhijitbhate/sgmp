package com.cme.oscar.reports.exceptions;

import com.cme.oscar.reports.enums.ErrorConstants;

public class ProcessingException extends RuntimeException{

    private ErrorConstants errorConstants;

    public ProcessingException(){
        super();
    }

    public ProcessingException(String exceptionMessage){
        super(exceptionMessage);
    }

    public ProcessingException(Throwable cause){
        super(cause);
    }

    public ProcessingException(String exceptionMessage, Throwable cause){
        super(exceptionMessage,cause);
    }

    public ProcessingException(ErrorConstants errorConstants){
        super(errorConstants.toString());
        this.errorConstants = errorConstants;
    }

    public ErrorConstants getErrorConstants() {
        return errorConstants;
    }

    public void setErrorConstants(ErrorConstants errorConstants) {
        this.errorConstants = errorConstants;
    }
}
