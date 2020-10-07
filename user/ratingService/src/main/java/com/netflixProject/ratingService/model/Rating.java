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
	
	
	public Rating() {
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
		this.setDateLastChanged(new Date());
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Long movieId) {
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
	
	
	/*
	 * Two ratings are equal when they have the same userID and movieID
	 */
	public static boolean equals(Rating r1, Rating r2) {		
		Long u1 = r1.getUserId();
		Long u2 = r2.getUserId();
		
		Long m1 = r1.getMovieId();
		Long m2 = r2.getMovieId();
		
		return (!u1.equals(u2)) && (!m1.equals(m2));
	}

}
