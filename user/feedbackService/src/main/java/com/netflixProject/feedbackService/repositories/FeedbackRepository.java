package com.netflixProject.feedbackService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflixProject.feedbackService.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
