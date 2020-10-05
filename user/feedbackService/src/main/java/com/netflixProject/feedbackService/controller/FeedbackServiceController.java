package com.netflixProject.feedbackService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflixProject.feedbackService.model.Feedback;
import com.netflixProject.feedbackService.repositories.FeedbackServiceRepository;

@RestController
public class FeedbackServiceController {
	
	@Autowired
	FeedbackServiceRepository feedbackRepository;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the feedback service!";
	}
	
	@GetMapping("/all")
	public List<Feedback> getAllFeedbacks(){
		return feedbackRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Feedback getFeedback(@PathVariable Long id) {
		return feedbackRepository.getOne(id);		
	}
	
	@PostMapping("/addFeedback")
	public void addFeedback(@RequestBody Feedback feedback) {
		feedbackRepository.save(feedback);
	}

}
