package com.netflixProject.ratingService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.netflixProject.ratingService.model.Rating;

public interface RatingServiceRepository extends JpaRepository<Rating, Long>{

}
