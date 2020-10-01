package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class MovieScraperService {

	
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
			
			movieList.add(new Movie(e.html()));
		}
	}

	public String getBestMovie() {
		this.scrape();
		return this.movieList.get(0).title;
	}

}
