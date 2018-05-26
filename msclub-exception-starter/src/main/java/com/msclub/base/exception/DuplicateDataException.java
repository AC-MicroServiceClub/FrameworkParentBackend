package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;

public class DuplicateDataException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = -1587929491526393625L;


	public DuplicateDataException(ErrorCode errorCode){
		super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), null);
	}

	public DuplicateDataException(ErrorCode errorCode, Throwable cause){
		super(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), errorCode.getIssueType(), cause);
	}

	@Override
	public HttpStatus getDefaultHttpStatus() {
		return HttpStatus.CONFLICT;
	}

}
