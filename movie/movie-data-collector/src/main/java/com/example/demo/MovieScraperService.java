package com.example.demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieScraperService {

	public void start() {
		System.out.println("Scraping.. ");
		
		
		Document doc = null;
		try {
		   doc = Jsoup.connect("https://www.imdb.com/chart/moviemeter/?sort=ir,desc&mode=simple&page=1").get(); // URL shortened!
		} catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		
		int x = 0;
		Elements elems = doc.select("tr").select("td").select("a[title]"); 

		for (Element e : elems) {
			System.out.println("-----" + x++);
			//System.out.println(e);
			//System.out.println(e.html().intern());
			System.out.println(e.html());


		}

		//System.out.println(doc);
		
		
	}

}
