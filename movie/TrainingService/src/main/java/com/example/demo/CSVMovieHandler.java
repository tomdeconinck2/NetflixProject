package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieDetail;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class CSVMovieHandler {

	public List<Movie> movieList = new ArrayList<Movie>();
	String fileName = "trainingset/movies_metadata_small.csv";
	
	public CSVMovieHandler() {
		System.out.println("TEST ");
		this.read();
	}

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
		return movieList.stream().filter(m -> m.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
	}
	
	
	
	public List<Movie> getMovieDetailsForMovie(int id){
		return movieList.stream().filter(m -> m.getMovieId() == id).collect(Collectors.toList());
	}



}
