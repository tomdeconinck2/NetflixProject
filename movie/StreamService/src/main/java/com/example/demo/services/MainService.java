package com.example.demo.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	public static final String VIDEO = "/video";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CONTENT_LENGTH = "Content-Length";
	public static final String VIDEO_CONTENT = "video/";
	public static final String BYTES = "bytes";
	public static final int BYTE_RANGE = 1024;

	
	public ResponseEntity<byte[]> get(String fileName, String fileType, String range) {

    	System.out.println(fileName);   	
        
        try {
        	File file = new File(fileName);
			InputStream inputStream = new FileInputStream(file);
			Long fileSize =file.length();
			Path p = Paths.get(fileName);
			byte[] data = Files.readAllBytes(p);
			
			return (ResponseEntity<byte[]>) ResponseEntity.status(HttpStatus.OK)
					.header(CONTENT_TYPE, VIDEO_CONTENT + fileType)
					.header(CONTENT_LENGTH, String.valueOf(fileSize))
					.body(data);
			
		} catch (IOException e) {
			System.out.println("CATCHED ");
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
