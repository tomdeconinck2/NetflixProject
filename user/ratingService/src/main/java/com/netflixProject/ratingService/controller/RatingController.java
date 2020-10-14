package com.netflixProject.ratingService.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflixProject.ratingService.model.Rating;
import com.netflixProject.ratingService.services.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	/*
	 * return a welcome message from this microservice
	 */
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the rating service!";
	}
	
	/*
	 * Return a list of all ratings in the database
	 */
	@GetMapping("/all")
	public List<Rating> getAllRatings() {
		return ratingService.getAllRatings();	
	}
	
	/*
	 * Get all ratings from a specific user
	 */
	@GetMapping("/ratingsOfUser/{userId}")
	public List<Rating> getRatingsForUser(@PathVariable("userId") Long userId){
		List<Rating> ratings = this.getAllRatings();
		return ratings.stream().filter(rating -> userId.equals(rating.getUserId())).collect(Collectors.toList());
	}

	
	/*
	 * Get the rating of given id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Rating> getRating(@PathVariable("id") Long id) {
		return ratingService.getRating(id);
	}	
	
	/*
	 * Add the given rating to the database.
	 * If the rating already exists the old value will be overwritten
	 */
	@PostMapping("/addRating")
	public ResponseEntity<String> addRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
	/*
	 * Delete the rating with given id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRating(@PathVariable("id") Long id){
		return ratingService.deleteRating(id);
	}

}
