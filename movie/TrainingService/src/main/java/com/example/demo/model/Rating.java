package com.example.demo.model;

public class Rating {
	
	private int userId;
	private int movieId;
	private double score;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Rating(int userId, int movieId, double score) {
		this.userId = userId;
		this.movieId = movieId;
		this.score = score;
	}


}
