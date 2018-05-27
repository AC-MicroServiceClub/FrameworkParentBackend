package com.msclub.base.model;

import org.springframework.http.HttpStatus;

public abstract class ErrorCode {

    private String code;
    private String message;
    private String issueType;
    private HttpStatus httpStatus;


    public ErrorCode(String code, String message, String issueType, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.issueType = issueType;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getIssueType() {
        return issueType;
    }
}
