package com.netflixProject.feedbackService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Feedback getFeedback(Long id) {
		return feedbackRepository.getOne(id);		
	}
	
	public boolean addFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
		return true;
	}

	public boolean deleteFeedback(Long id) {
		try {
			feedbackRepository.deleteById(id);
			return true;
		}
		catch(IllegalArgumentException e) {
			return false;
		}
	}

}
