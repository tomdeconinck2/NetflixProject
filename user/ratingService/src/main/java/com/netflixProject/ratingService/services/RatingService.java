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
	

	public List<Rating> getAllUsers() {
		return ratingRepository.findAll();	
	}
	

	public ResponseEntity<Rating> getRating(Long id) {
		try {
			Rating r = ratingRepository.getOne(id);
			return new ResponseEntity<>(r,HttpStatus.OK);
		}
		catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	public ResponseEntity<String> addRating(Rating rating) {
		ratingRepository.save(rating);
		return new ResponseEntity<>("New Rating added", HttpStatus.CREATED);
	}


	public ResponseEntity<String> deleteRating(Long id) {
		try {
			ratingRepository.deleteById(id);
			return new ResponseEntity<>("Rating deleted", HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<>("Rating did not exist", HttpStatus.NOT_FOUND);
		}
	}

}
