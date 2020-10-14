package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;

public class Movie {

	@CsvBindByName(column = "id")
	private int movieId;

	@CsvBindByName(column = "original_title")
	private String title;

	@CsvBindByName(column = "genres")
	private String genre;

	private String mainGenre;

	// @CsvBindAndSplitByName(column = "genres", elementType = String.class, splitOn
	// = ",", collectionType = LinkedList.class)
	// List<? extends String> genre2;

	@CsvBindByName(column = "vote_average")
	private double score;

	@CsvBindByName(column = "vote_count")
	private int nbOfVotes;

	@CsvBindByName(column = "imdb_id")
	private String imdbIdString;
	
	private int imdbId;

	@CsvBindByName(column = "overview")
	private String description;

	public void init() {
		this.mainGenre = genre.split("name")[1].substring(4).split("'")[0];
		this.imdbId = Integer.parseInt(this.imdbIdString.substring(2));
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", mainGenre=" + mainGenre + ", score=" + score
				+ ", nbOfVotes=" + nbOfVotes + ", imdbId=" + imdbId + ", description=" + description + "]";
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMainGenre() {
		return mainGenre;
	}

	public void setMainGenre(String mainGenre) {
		this.mainGenre = mainGenre;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getNbOfVotes() {
		return nbOfVotes;
	}

	public void setNbOfVotes(int nbOfVotes) {
		this.nbOfVotes = nbOfVotes;
	}

	public int getImdbId() {
		return imdbId;
	}

	public void setImdbId(int imdbId) {
		this.imdbId = imdbId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
