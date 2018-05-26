package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;

public class UnauthorisedException extends BaseException {

    private static final long serialVersionUID = 6615431437462350380L;

    public UnauthorisedException(ErrorCode errorCode){
        super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), null);
    }

    public UnauthorisedException(ErrorCode errorCode, Throwable cause){
        super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), cause);
    }

    @Override
    public HttpStatus getDefaultHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
