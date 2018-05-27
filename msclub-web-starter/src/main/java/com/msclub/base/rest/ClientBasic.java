package com.msclub.base.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ClientBasic {

    public <T> ResponseEntity<T> fallback(String url, HttpMethod method,
                                          HttpEntity<?> requestEntity, Class<T> responseType, Throwable e) {
        return new ResponseEntity<T>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
