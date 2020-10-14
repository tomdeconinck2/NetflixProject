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
	
	private Long user_id;	
	private Long movie_id;
	private int rating;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private final Date date_created = new Date();
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private Date date_last_changed = new Date();	
	
	/*
	 * Default constructor
	 */
	public Rating() {
	}
	
	
	public Rating(Long userId, Long movieId, int rating) {
		this.user_id = userId;
		this.movie_id = movieId;
		this.rating = rating;
	}
	
	
	/*
	 * Standard getters and setters for all attributes
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.setDateLastChanged(new Date());
		this.id = id;
	}

	public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long userId) {
		this.setDateLastChanged(new Date());
		this.user_id = userId;
	}

	public Long getMovieId() {
		return movie_id;
	}
	
	public void setMovieId(Long movieId) {
		this.setDateLastChanged(new Date());
		this.movie_id = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int newRating) {
		this.setDateLastChanged(new Date());
		this.rating = newRating;
	}

	public Date getDateLastChanged() {
		return date_last_changed;
	}

	public void setDateLastChanged(Date dateLastChanged) {
		this.date_last_changed = dateLastChanged;
	}

	public Date getDateCreated() {
		return date_created;
	}
	
	
	/*
	 * Two ratings are equal when they have the same userID and movieID
	 */
	public static boolean equals(Rating r1, Rating r2) {		
		Long u1 = r1.getUserId();
		Long u2 = r2.getUserId();
		
		Long m1 = r1.getMovieId();
		Long m2 = r2.getMovieId();
		
		return (u1.equals(u2) && m1.equals(m2));
	}

}
