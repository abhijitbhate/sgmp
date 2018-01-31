package com.cme.oscar.reports.exceptions;

import com.cme.oscar.reports.enums.ErrorConstants;

public class APIException extends RuntimeException {

    private ErrorConstants errorConstants;

    public APIException(ErrorConstants errorConstants){
        super(errorConstants.toString());
        this.errorConstants = errorConstants;
    }

    public ErrorConstants getErrorConstants() {
        return errorConstants;
    }

    public void setErrorConstants(ErrorConstants errorConstants){
        this.errorConstants = errorConstants;
    }
}
