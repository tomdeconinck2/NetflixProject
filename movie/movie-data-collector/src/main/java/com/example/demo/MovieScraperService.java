package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieScraperService {

	@Autowired
	MovieRepository mr;
	
	MovieScraperService() {	
	}
	
	
	List<Movie> movieList = new ArrayList<Movie>();
	
	public void scrape() {
		System.out.println("Scraping.. ");
		Document doc = null;
		try {
		   doc = Jsoup.connect("https://www.imdb.com/chart/moviemeter/?sort=ir,desc&mode=simple&page=1").get(); 
		} catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		
		int x = 0; 
		int wantedMovies = 10;
		Elements elems = doc.select("tr").select("td").select("a[title]"); 

		for (Element e : elems) {
			if (x++ > wantedMovies) {
				break;
			}

			System.out.println(e.html());
			
			Movie m = new Movie(e.html(), (long) (x + 1));
			movieList.add(m);
			addToDb(m);
		}
	}


	private void addToDb(Movie m) {
		System.out.println("Test");
		System.out.println(this.mr);
		this.mr.save(m);
	}


	public String getBestMovie() {
		if (this.movieList.isEmpty()) this.scrape();
		return this.movieList.get(0).title;
	}

}
