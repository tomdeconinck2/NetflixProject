package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	MovieScraperService mss;
	
	MovieRepository mr;
	
	
	@Autowired
	private MovieController(MovieScraperService mss, MovieRepository mr) {
		this.mss = mss;
		this.mr = mr;
	}
		
	@GetMapping("/")
	public String get2() {
		//return m.movieList.get(0).title;
		return "Best movie is: " + mss.getBestMovie();
	}
	
	@GetMapping("/movies")
	public List<Movie> list() {
		return this.mr.findAll();
	}
	
	


}
