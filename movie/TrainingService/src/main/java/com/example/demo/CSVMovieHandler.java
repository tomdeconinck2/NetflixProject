package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Movie;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVMovieHandler {

	List<Movie> movieList = new ArrayList<Movie>();
	String fileName = "trainingset/movies_metadata_small.csv";

	public void read() {
		try {
			CsvToBean<Movie> beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Movie.class)
					.withThrowExceptions(false)
					.build();

			
			movieList = beans.parse();
			movieList.stream().forEach((movie) -> {
				movie.init();
				System.out.println(movie.toString());
			});

			beans.getCapturedExceptions().stream().forEach((exception) -> { 
				System.out.println("Inconsistent data:" + exception);
			});

		} catch (IllegalStateException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
			// e.printStackTrace();
		}
		
		getStats();
		System.out.println(getMoviesWithGenre("action"));

	}



	private void getStats() {
		System.out.println("Stats about ratings: ");
		System.out.println(movieList.size());

	}

	private List<Movie> getMoviesWithGenre(String genre) {
		//return movieList.stream().filter(a -> a.getGenre().equals(genre)).collect(Collectors.toList());
		return movieList.stream().filter(a -> a.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
	}



}
