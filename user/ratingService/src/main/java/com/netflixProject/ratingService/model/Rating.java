package com.netflixProject.ratingService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Rating")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long userId;	
	private Long movieId;
	private int Rating;
	
	private int MIN_RATING = 0;
	private int MAX_RATING = 10;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private final Date dateCreated = new Date();
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private Date dateLastChanged = new Date();
	
	
	public Rating(Long userId, Long movieId, int Rating) {
		//TODO check if there is not already a rating from the given user for the given movie
		this.userId = userId;
		this.movieId = movieId;
		this.Rating = Rating;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.setDateLastChanged(new Date());
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		//TODO check if there is not already a rating from the given user for the given movie
		this.setDateLastChanged(new Date());
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		//TODO check if there is not already a rating from the given user for the given movie
		this.setDateLastChanged(new Date());
		this.movieId = movieId;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		if(rating < MIN_RATING || rating > MAX_RATING){
			throw new IllegalArgumentException();
		}
		else {
			this.setDateLastChanged(new Date());
			Rating = rating;
		}
	}

	public Date getDateLastChanged() {
		return dateLastChanged;
	}

	public void setDateLastChanged(Date dateLastChanged) {
		this.dateLastChanged = dateLastChanged;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	

}
