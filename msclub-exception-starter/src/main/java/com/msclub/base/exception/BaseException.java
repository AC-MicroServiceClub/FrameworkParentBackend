package com.msclub.base.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = -4905994053726819530L;

	private final String code;
	private final String message;
	private final Throwable cause;
	private final HttpStatus httpStatus;
	private final String issueType;

	private String errorContext; //NOSONAR sometimes, this field is not added when initialized. So cannot add final
	private String errorDescription;//NOSONAR sometimes, this field is not added when initialized. So cannot add final
	private String errorCorrection;//NOSONAR sometimes, this field is not added when initialized. So cannot add final
	private String url;//NOSONAR sometimes, this field is not added when initialized. So cannot add final
	private String responseBody;//NOSONAR sometimes, this field is not added when initialized. So cannot add final

	private HashMap<String, Object> additionalInfos = new HashMap<>(); //NOSONAR sometimes, this field is not added when initialized. So cannot add final

	public BaseException(String code, String message, HttpStatus httpStatus, String issueType, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.message = message;
		this.issueType = issueType;
		this.httpStatus = httpStatus==null?getDefaultHttpStatus():httpStatus;
		this.cause = cause;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public Throwable getCause() {
		return cause;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getErrorContext() {
		return errorContext;
	}

	public void setErrorContext(String errorContext) {
		this.errorContext = errorContext;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorCorrection() {
		return errorCorrection;
	}

	public void setErrorCorrection(String errorCorrection) {
		this.errorCorrection = errorCorrection;
	}

	public Map<String, Object> getParameters() {
		return additionalInfos;
	}

	public void addParameters(String key, Object value) {
		this.additionalInfos.put(key, value);
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public HttpStatus getDefaultHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public String getIssueType() {
		return issueType;
	}
}
