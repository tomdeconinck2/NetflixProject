package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import Scraping.DataScraper;

@Service
public class CSVMovieHandler {

	public List<Movie> movieList = new ArrayList<Movie>();
	String fileName = "trainingset/movies_metadata_small.csv";

	DataScraper dataScraper = new DataScraper();

	public CSVMovieHandler() {
		System.out.println("TEST ");
		this.read();
	}

	public void read() {
		try {
			CsvToBean<Movie> beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Movie.class).withThrowExceptions(false).build();

			movieList = beans.parse();
			movieList.stream().forEach((movie) -> {
				movie.init();
				this.dataScraper.findMovieMediaUrls(movie);
				System.out.println(movie.toString());
			});
			//this.dataScraper.findMovieMediaUrls(movieList.get(0));

			beans.getCapturedExceptions().stream().forEach((exception) -> { System.out.println("Inconsistent data:" + exception); });

		} catch (IllegalStateException | FileNotFoundException e) {
			System.out.println("ERROR");
		}

		getStats();


	}

	private void getStats() {
		System.out.println("Stats about ratings: ");
		System.out.println(movieList.size());
		System.out.println(getMoviesWithGenre("action"));

	}

	private List<Movie> getMoviesWithGenre(String genre) {
		// return movieList.stream().filter(a ->
		// a.getGenre().equals(genre)).collect(Collectors.toList());
		return movieList.stream().filter(m -> m.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
	}

	public List<Movie> getMovieDetailsForMovie(int id) {
		return movieList.stream().filter(m -> m.getMovieId() == id).collect(Collectors.toList());
	}

}
