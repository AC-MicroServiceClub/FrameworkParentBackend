package com.msclub.base.rest;

import com.msclub.base.model.ErrorCode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface RestClient {
	 <T> ResponseEntity<T> getResponse(String url, HttpMethod method,
             HttpEntity<?> requestEntity, Class<T> responseType, ErrorCode errorCode) ;

	 @Deprecated
	 <T> ResponseEntity<T> getResponse(String url, HttpMethod method,
             HttpEntity<?> requestEntity, Class<T> responseType) ;
	 
	 <T> ResponseEntity<T> fallback(String url, HttpMethod method,
             HttpEntity<?> requestEntity, Class<T> responseType, Throwable e) ;
}
