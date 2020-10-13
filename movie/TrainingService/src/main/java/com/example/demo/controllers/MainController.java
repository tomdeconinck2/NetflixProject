package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVMovieHandler;
import com.example.demo.model.Movie;

@RestController
public class MainController {
	
	
	@Autowired 
	CSVMovieHandler csvMov;
	
	public MainController() {
		System.out.println("This constructor is called ");
		//csvMov.read();
	}
	
	@RequestMapping("/explore2")
	public String explore2() {
		return "TEST";
	}

	@RequestMapping("/explore")
	public List<Movie> explore() {
		return csvMov.movieList;
	}
	
	@RequestMapping("/detail")
	public List<Movie> detail(@RequestParam String id) {
		return csvMov.getMovieDetailsForMovie(Integer.parseInt(id));
	}
	
	
	
	@RequestMapping("/")
	public String home() {
		return "HOME";
	}
	
	

}
