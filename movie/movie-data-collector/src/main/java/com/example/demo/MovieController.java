package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/old")
	public String getOld() {
		return "Best moviee is: " + mss.getBestMovie();
	}
	
	@GetMapping("/")
	public ResponseEntity<String> get2() {
		return new ResponseEntity<>(" Best movie is:  " + mss.getBestMovie(), HttpStatus.ACCEPTED); 
	}

	@GetMapping("/movies")
	public List<Movie> list() {
		return this.mr.findAll().stream()
				.filter(movie -> movie.id != 1).collect(Collectors.toList());
	}

}
