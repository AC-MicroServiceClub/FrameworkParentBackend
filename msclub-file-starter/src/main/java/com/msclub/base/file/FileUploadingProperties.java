package com.msclub.base.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(FileUploadingProperties.PREFIX)
public class FileUploadingProperties {
    public static final String PREFIX = "msclub.fileuploadingConfig";

    private String filePath = "";

	public static String getPREFIX() {
        return PREFIX;
    }

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

 
}
