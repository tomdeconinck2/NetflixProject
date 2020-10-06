package com.netflixProject.feedbackService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflixProject.feedbackService.model.Feedback;
import com.netflixProject.feedbackService.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the feedback service!";
	}
	
	@GetMapping("/all")
	public List<Feedback> getAllFeedbacks(){
		return feedbackService.getAllFeedbacks();
	}
	
	@GetMapping("/{id}")
	public Feedback getFeedback(@PathVariable Long id) {
		return feedbackService.getFeedback(id);		
	}
	
	@PostMapping("/addFeedback")
	public ResponseEntity<Long> addFeedback(@RequestBody Feedback feedback) {
		boolean isAdded = feedbackService.addFeedback(feedback);
		if(isAdded) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteFeedback(@PathVariable("id") Long id){
		boolean isDeleted = feedbackService.deleteFeedback(id);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
