package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MainService;

import reactor.core.publisher.Mono;

@RestController
public class MainController {

	@Autowired
	MainService service;

	@RequestMapping("/home")
	public String home() {
		return "HOME";
	}

	// Function to test sending mp4 files, from the backend
	// set request headers: range
	// set response headers: accept-ranges, content-range, content-type, content-length

	String fileName = "movies/test.mp4";
	String fileType = "mp4";

	@GetMapping("/test")
	public Mono<ResponseEntity<byte[]>> streamVideo(ServerHttpResponse serverHttpResponse,
			@RequestHeader(value = "Range", required = false) String httpRangeList) {
		
		return Mono.just(service.get(fileName, fileType, httpRangeList));
	}
	
	


}
