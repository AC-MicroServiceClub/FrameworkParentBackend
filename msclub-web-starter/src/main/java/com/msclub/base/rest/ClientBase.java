package com.msclub.base.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.msclub.base.exception.ServiceException;
import com.msclub.base.model.CommonResponseCode;
import com.msclub.base.model.ErrorCode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class ClientBase extends ClientBasic implements RestClient{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param url
     * @param method
     * @param requestEntity
     * @param responseType
     * @param errorCode
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> getResponse(String url, HttpMethod method,
                                             HttpEntity<?> requestEntity, Class<T> responseType, ErrorCode errorCode) {
        ResponseEntity<T> responseEntity = restTemplateResponse(url, method, requestEntity, responseType);
        if (HttpStatus.SERVICE_UNAVAILABLE == responseEntity.getStatusCode()){
            throw new ServiceException(errorCode);
        }
        return responseEntity;
    }

    /**
     * Deprecated. Use the method sending the error code.
     * @param url
     * @param method
     * @param requestEntity
     * @param responseType
     * @param <T>
     * @return
     */
    @Deprecated
    public <T> ResponseEntity<T> getResponse(String url, HttpMethod method,
                                              HttpEntity<?> requestEntity, Class<T> responseType) {
        ResponseEntity<T> responseEntity = restTemplateResponse(url, method, requestEntity, responseType);
        if (HttpStatus.SERVICE_UNAVAILABLE == responseEntity.getStatusCode()){
            throw new ServiceException(CommonResponseCode.ERROR_000001);
        }
        return responseEntity;
    }

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")},
            ignoreExceptions = {HttpStatusCodeException.class})
    public <T> ResponseEntity<T> restTemplateResponse(String url, HttpMethod method,
                                             HttpEntity<?> requestEntity, Class<T> responseType) {
        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

}
