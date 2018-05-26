package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;

public class BusinessException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2725069780090200905L;


	public BusinessException(ErrorCode errorCode){
		super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), null);
	}

	public BusinessException(ErrorCode errorCode, Throwable cause){
		super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), cause);
	}

	@Override
	public HttpStatus getDefaultHttpStatus() {
		return HttpStatus.FORBIDDEN;
	}
}
