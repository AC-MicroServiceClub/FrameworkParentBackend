package com.msclub.base.rest;

import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Provides a {@link org.springframework.web.client.RestTemplate} configured with
 * a pooled {@link HttpClient} suitable to perform better on an enterprise environment.
 */
@Configuration
public class RestTemplateAutoConfiguration {

    @Bean
    public RestTemplate restTemplate(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(requestFactory);
    }

    @Bean
    public RestClient restClient(){
        return new ClientBase();
    }
}
