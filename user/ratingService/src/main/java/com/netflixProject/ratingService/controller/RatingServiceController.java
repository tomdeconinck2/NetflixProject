package com.netflixProject.ratingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflixProject.ratingService.model.Rating;
import com.netflixProject.ratingService.repositories.RatingServiceRepository;

@RestController
public class RatingServiceController {
	
	@Autowired
	RatingServiceRepository ratingRepository;
	
	@GetMapping
	public String welcome() {
		return "Welcome to the rating service!";
	}
	
	@GetMapping("all")
	public List<Rating> getAllUsers() {
		return ratingRepository.findAll();	
	}
	
	@GetMapping("{id}")
	public Rating getRating(@PathVariable("id") Long id) {
		return ratingRepository.getOne(id);
	}
	
	@GetMapping("/addRating")
	public void addRating(@RequestBody Rating rating) {
		ratingRepository.save(rating);
	}

}
