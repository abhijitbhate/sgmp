package com.cme.oscar.reports.responses;

import com.cme.oscar.reports.beans.APIError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorResponse implements Serializable{

    private String code;
    private String message;
    private List<APIError> apiErrors = new ArrayList<>(0);

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message, List<APIError> apiErrors) {
        this.code = code;
        this.message = message;
        this.apiErrors = apiErrors;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<APIError> getApiErrors() {
        return apiErrors;
    }

    public void setApiErrors(List<APIError> apiErrors) {
        this.apiErrors = apiErrors;
    }

    @Override
    public String toString() {
        return "ErrorResponse [code=" + code + ", message=" + message + ", apiErrors=" + apiErrors + "]";
    }
}
