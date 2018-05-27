package com.msclub.base.rest;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientCommonConfiguration {
	
    protected HttpClientBuilder httpClientBuilder(int maxConnTotal, int maxConnPerRoute, int connectionTimeout, int socketTimeout, int defaultRetryTimes) {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout).build();

        return HttpClientBuilder.create().setDefaultRequestConfig(config)
                .setMaxConnTotal(maxConnTotal)
                .setMaxConnPerRoute(maxConnPerRoute)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(defaultRetryTimes, false));
    }
}
