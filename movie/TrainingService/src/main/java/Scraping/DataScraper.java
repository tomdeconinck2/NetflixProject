package Scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.demo.model.Movie;

public class DataScraper {

	public void findMovieMediaUrls(Movie movie) {
		
		System.out.println("- - - - -Started Scraping - - - -- - - ");
		String imgUrl = "testUrl";
		
		String url = "https://www.imdb.com/title/tt0" +movie.getImdbId();

		Document doc = null;
		try {
		   doc = Jsoup.connect(url).get();
		   //System.out.println(doc);
		} catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		// Elements elems = doc.select("tr").select("td").select("a[title]"); 
		Elements elems = doc.getElementsByClass("poster"); 
		
		int x = 0;
		for (Element e : elems) {
			x++;
			System.out.println(e.html());
		}
		
		imgUrl = doc.getElementsByClass("poster").select("img").first().attr("src"); 
			
		
		System.out.println("Finished with scraping. Found url: " + imgUrl + " " + x);

	movie.setImageUrl(imgUrl);

}

}
