package com.msclub.base.rest;

import org.apache.http.client.HttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RestTemplateConfigurationProperties.class)
public class HttpClientAutoConfiguration  extends HttpClientCommonConfiguration{

    @Bean
    public HttpClient httpClient(RestTemplateConfigurationProperties properties) {
        return httpClientBuilder(properties.getMaxConnTotal(),
                properties.getMaxConnPerRoute(),
                properties.getConnectionTimeout(),
                properties.getSocketTimeout(),
                properties.getDefaultRetryTimes()).build();
    }

}
