package com.cme.oscar.reports.beans;

import java.io.Serializable;

public class APIError implements Serializable{

	private static final long serialVersionUID = -5691751510025482727L;
	
	private String field;
    private String message;
    private String violatedConstraint;

    public APIError(){}

    public APIError(String field, String message, String violatedConstraint) {
        this.field = field;
        this.message = message;
        this.violatedConstraint = violatedConstraint;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getViolatedConstraint() {
		return violatedConstraint;
	}

	public void setViolatedConstraint(String violatedConstraint) {
		this.violatedConstraint = violatedConstraint;
	}

	@Override
	public String toString() {
		return "APIError [field=" + field + ", message=" + message + ", violatedConstraint=" + violatedConstraint + "]";
	}
    
}
