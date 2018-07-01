package com.msclub.base.file;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;

@Controller
public class FileUpload {
	
	private FileUploadingProperties properties;
	

	public FileUpload(FileUploadingProperties properties) {
		this.properties = properties;
	}


	public void uploadFile(byte[] file ) throws Exception { 
        File targetFile = new File(properties.getFilePath());  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(properties.getFilePath());
        out.write(file);
        out.flush();
        out.close();
    }

  

}