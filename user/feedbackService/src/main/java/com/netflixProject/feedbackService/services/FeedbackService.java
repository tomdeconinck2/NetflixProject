package com.netflixProject.feedbackService.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflixProject.feedbackService.model.Feedback;
import com.netflixProject.feedbackService.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;

	
	public List<Feedback> getAllFeedbacks(){
		return feedbackRepository.findAll();
	}
	
	public ResponseEntity<Feedback> getFeedback(Long id) {
		try {
			Feedback f = feedbackRepository.getOne(id);
			return new ResponseEntity<>(f,HttpStatus.OK);
		}
		catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> addFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
		return new ResponseEntity<>("New Feedback is added", HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteFeedback(Long id) {
		try {
			feedbackRepository.deleteById(id);
			return new ResponseEntity<>("Feedback is deleted", HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
