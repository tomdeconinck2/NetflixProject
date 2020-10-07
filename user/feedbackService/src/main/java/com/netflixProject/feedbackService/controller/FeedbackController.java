package com.netflixProject.feedbackService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<Feedback> getFeedback(@PathVariable Long id) {
		return feedbackService.getFeedback(id);		
	}
	
	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.addFeedback(feedback);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFeedback(@PathVariable("id") Long id){
		return feedbackService.deleteFeedback(id);
	}
}
