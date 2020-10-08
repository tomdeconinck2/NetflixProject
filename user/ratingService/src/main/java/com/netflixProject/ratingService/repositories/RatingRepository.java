package com.netflixProject.ratingService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflixProject.ratingService.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

}
