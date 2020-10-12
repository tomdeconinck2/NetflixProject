package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	
	
	@RequestMapping("/explore")
	public String explore() {
		return "TEST";
	}
	
	@RequestMapping("/")
	public String home() {
		return "HOME";
	}

}
