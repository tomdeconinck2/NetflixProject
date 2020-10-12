package com.example.demo.model;

import java.util.LinkedList;
import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

public class Movie {

	
	@CsvBindByName(column = "id")
	private int movieId;
	
	@CsvBindByName(column = "original_title")
	private String title;
	
	@CsvBindByName(column = "genres")
	private String genre;

	private String mainGenre;

    //@CsvBindAndSplitByName(column = "genres", elementType = String.class, splitOn = ",", collectionType = LinkedList.class)
    //List<? extends String> genre2;
	
	@CsvBindByName(column = "vote_average")	
	private double score;
	
	@CsvBindByName(column = "vote_count")
	private int nbOfVotes;


	public void init() {
		String x = genre.split("name")[1].substring(4).split("'")[0];
		//System.out.println("X is " + x);
		this.mainGenre = x;		
	}



	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + mainGenre + ", score=" + score
				+ ", nbOfVotes=" + nbOfVotes + "]" ;
	}














	public String getGenre() {
		return "action";
	}
	
}
