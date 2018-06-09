package com.msclub.base.file;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;

@Controller
public class FileUpload {
	private static String pilePath = "";
	
	

	public FileUpload(String pilePath) {
		super();
		this.pilePath = pilePath;
	}



	public static void uploadFile(byte[] file, String fileName) throws Exception { 
        File targetFile = new File(pilePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(pilePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

  

}