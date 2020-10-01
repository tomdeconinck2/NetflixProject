package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	MovieScraperService m;
	
	@Autowired
	private MovieController(MovieScraperService m) {
		this.m = m;
	}
		
	@GetMapping("/")
	public String get2() {
		//return m.movieList.get(0).title;
		return "Best movie is: " + m.getBestMovie();
	}


}
