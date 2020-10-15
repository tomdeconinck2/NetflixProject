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

		String url = "https://www.imdb.com/title/tt0" + movie.getImdbId();

		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			// System.out.println(doc);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// IMAGE:
		String imgUrl = "testUrl";
		// TODO when no bugs occur, the next 5 lines can be deleted.
		Elements elems = doc.getElementsByClass("poster");
		int x = 0;
		for (Element e : elems) {
			x++;
			System.out.println(e.html());
		}

		imgUrl = doc.getElementsByClass("poster").select("img").first().attr("src");

		//TODO clean up if it works. 
		// VIDEO TRAILER:

		String movieUrl = "Not Found";
		boolean scrapeAll = false;
		scrapeAll = true;
		
		if (movie.getMovieId() == 862 || scrapeAll == true) { // Scrape only for the first movie, else you will get IP blacklisted by idbm I suppose. 
			try {
				String temp = doc.getElementsByClass("slate").select("a").first().attr("href");

				String newUrl = "https://www.imdb.com/video/vi" + temp.split("vi")[2];
				doc = Jsoup.connect(newUrl).get();

				elems = doc.select("script");
				for (Element e : elems) {
					if (e.html().contains("mp4")) {
						System.out.println("FOUND ?");
						String s = e.html().split("video/mp4")[1];
							s = s.split("vi")[2];
						s = s.split("}")[0];
						System.out.println(s);
						String extra = s.substring(0, s.length() - 2);
						movieUrl = "https://imdb-video.media-imdb.com/vi" + extra;
					}

				}

			} catch (Exception e) {
				movieUrl = "Not Found";
				e.printStackTrace();
			}
		}
		System.out.println("Finished with scraping. Found url: " + imgUrl + "and\n" + movieUrl);

		movie.setImageUrl(imgUrl);
		movie.setMovieUrl(movieUrl);
		// TODO some catching-try to ensure that it doesn't throw exceptions?

	}

}
