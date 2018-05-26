package com.msclub.base.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@ConfigurationProperties(RestTemplateConfigurationProperties.PREFIX)
public class RestTemplateConfigurationProperties {
    public static final String PREFIX = "msclub.restTemplateConfig";

    private int maxConnTotal = 40;
    private int maxConnPerRoute = 20;
    private int connectionTimeout = 2000;
    private int socketTimeout = 5000;
    private int defaultRetryTimes = 3;

	public static String getPREFIX() {
        return PREFIX;
    }

    public int getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(int maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }

    public int getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(int maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
    
    public int getDefaultRetryTimes() {
		return defaultRetryTimes;
	}

	public void setDefaultRetryTimes(int defaultRetryTimes) {
		this.defaultRetryTimes = defaultRetryTimes;
	}
}
