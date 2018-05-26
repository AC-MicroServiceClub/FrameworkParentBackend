package com.msclub.base.model;

import org.springframework.http.HttpStatus;

import com.msclub.base.model.ErrorCode;


public class CommonResponseCode extends ErrorCode{

	public CommonResponseCode(String code, String message, IssueType issueType, HttpStatus httpStatus) {
		super(code, message, issueType.name(), httpStatus);
	}
	
	public static final ErrorCode ERROR_000001 = new CommonResponseCode("ERROR_000001", "Back end system temporary unavailable", IssueType.EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);

}
