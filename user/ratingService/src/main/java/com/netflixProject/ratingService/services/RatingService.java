package com.netflixProject.ratingService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	

	public Rating getRating(Long id) {
		return ratingRepository.getOne(id);
	}
	

	public boolean addRating(Rating rating) {
		ratingRepository.save(rating);
		return true;
	}


	public boolean deleteRating(Long id) {
		try {
			ratingRepository.deleteById(id);
			return true;
		}
		catch(IllegalArgumentException e) {
			return false;
		}
	}

}
