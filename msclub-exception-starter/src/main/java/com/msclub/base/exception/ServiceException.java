package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;

public class ServiceException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5307649247542681018L;


    public ServiceException(ErrorCode errorCode){
        super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), null);
    }

    public ServiceException(ErrorCode errorCode, Throwable cause){
        super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), cause);
    }

    @Override
    public HttpStatus getDefaultHttpStatus() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }
}
