package com.NetflixProject.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping()
	public String testResponce() {
		return "Hello from testcontroller!!";
	}
	

}
