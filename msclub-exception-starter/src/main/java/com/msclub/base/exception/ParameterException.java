package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;

public class ParameterException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996548427252334325L;


	public ParameterException(ErrorCode errorCode){
		super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), null);
	}

	public ParameterException(ErrorCode errorCode, Throwable cause){
		super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), cause);
	}

	@Override
	public HttpStatus getDefaultHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
