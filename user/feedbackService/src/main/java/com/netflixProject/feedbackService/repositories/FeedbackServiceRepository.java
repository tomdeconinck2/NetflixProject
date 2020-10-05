package com.netflixProject.feedbackService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netflixProject.feedbackService.model.Feedback;

public interface FeedbackServiceRepository extends JpaRepository<Feedback, Long>{

}
