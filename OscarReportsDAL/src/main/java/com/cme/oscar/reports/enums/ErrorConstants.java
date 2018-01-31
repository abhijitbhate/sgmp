package com.cme.oscar.reports.enums;

public enum ErrorConstants {

    INVALID_REPORT_REQUEST("API-01", "The report request found invalid.", 400),

    EXCEPTION_FETCHING_REQUESTED_REPORTS("DAO-01", "Something went wrong while fetching requested reports.", 500);

    private final String errorCode;
    private final String description;
    private final Integer statusCode;

    private ErrorConstants(String errorCode, String description, Integer statusCode){
        this.errorCode = errorCode;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getErrorCode(){
        return errorCode;
    }

    public String getDescription(){
        return description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString(){
        return new StringBuilder(errorCode).append(":").append(description).append(":").append(statusCode).toString();
    }
}
