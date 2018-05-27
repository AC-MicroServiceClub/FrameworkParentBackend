package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;

public class TechnicalFailureException extends BaseException {

    private static final long serialVersionUID = -1412462125800926189L;

    public TechnicalFailureException(ErrorCode errorCode, Throwable cause){
        super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), cause);
    }

    @Override
    public HttpStatus getDefaultHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
