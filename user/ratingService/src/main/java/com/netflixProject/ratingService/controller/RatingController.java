package com.netflixProject.ratingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflixProject.ratingService.model.Rating;
import com.netflixProject.ratingService.services.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the rating service!";
	}
	
	@GetMapping("/all")
	public List<Rating> getAllUsers() {
		return ratingService.getAllUsers();	
	}
	
	@GetMapping("/{id}")
	public Rating getRating(@PathVariable("id") Long id) {
		return ratingService.getRating(id);
	}
	
	
	
	@GetMapping("/addRating")
	public ResponseEntity<Long> addRating(@RequestBody Rating rating) {
		boolean isAdded = ratingService.addRating(rating);
		if(isAdded) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteRating(@PathVariable("id") Long id){
		boolean isDeleted = ratingService.deleteRating(id);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
