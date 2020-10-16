package com.netflixProject.ratingService.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflixProject.ratingService.model.Rating;
import com.netflixProject.ratingService.repositories.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	RatingRepository ratingRepository;

	/*
	 * A rating must be between 0 and 10
	 */
	private static final int MIN_RATING = 0;
	private static final int MAX_RATING = 10;
	

	/*
	 * Return a list containing all ratings in the database
	 */
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();	
	}
	

	/*
	 * return the rating for the given id
	 */
	public ResponseEntity<Rating> getRating(Long id) {
		try {
			Rating r = ratingRepository.getOne(id);
			return new ResponseEntity<>(r,HttpStatus.OK);
		}
		catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * Add the given rating to the database
	 * If the rating already exists the previous rating gets overwritten
	 */
	public ResponseEntity<String> addRating(Rating rating) {
		if(isValidRating(rating)) {
			deleteIfRatingExists(rating); //If the rating already exist the old rating must first be deleted so it can be overwritten
			ratingRepository.save(rating);
			return new ResponseEntity<>("New Rating added", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("A Rating from this user for this movie already exists",HttpStatus.PRECONDITION_FAILED);
		}
	}

	/*
	 * Delete the rating with given id
	 */
	public ResponseEntity<String> deleteRating(Long id) {
		try {
			ratingRepository.deleteById(id);
			return new ResponseEntity<>("Rating deleted", HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<>("Rating did not exist", HttpStatus.NOT_FOUND);
		}
	}	
	
	/*
	 * Delete all the ratings of the given user
	 */
	public void deleteRatingsOfUser(Long userId) {
		List<Rating> allRatings = this.getAllRatings();		
		allRatings.stream()
					.filter(r -> r.getUserId() == userId)
					.forEach(r -> this.deleteRating(r.getId()));
	}
	
	/*
	 * Delete the same rating as the given rating if it exists
	 * Ratings are the same when they have an equal user_id and movie_id
	 */ 
	public void deleteIfRatingExists(Rating rating) {
		Long idToDelete = null;
		List<Rating> allRatings = getAllRatings();
		
		for(Rating r : allRatings) {
			if(Rating.equals(r, rating)) {
				idToDelete = r.getId();
			}
		}
		
		if(idToDelete != null) {
			deleteRating(idToDelete);
		}
		
	}
	
	/*
	 * Check if the given rating is a valid rating.
	 * A rating is valid if it is in the range [MIN_RATING, MAX_RATING]
	 */
	private boolean isValidRating(Rating rating) {
		return rating.getRating() >= MIN_RATING && rating.getRating() <= MAX_RATING;
	}

}
