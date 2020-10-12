package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.NetflixProject.UserService.model.User;
import com.example.demo.model.Rating;


public class CSVRatingHandler {

	List<Rating> ratingList = new ArrayList<Rating>();

	public void read() {

		String fileName = "trainingset/ratings_small.csv";

		Path path = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
			// read the first line from the text file
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				Rating rating = createRating(attributes);
				ratingList.add(rating);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		getStats();
	}

	private void getStats() {
		System.out.println("Stats about ratings: ");
		System.out.println(ratingList.size());
			
		System.out.println(getMeanRating(ratingList));

		System.out.println(getMeanRatingForUser(1));
		System.out.println(getMeanRatingForUser(2));
		
	}
	
	
	
	
	
	private double getMeanRatingForUser(int i) {
		return getMeanRating(getRatingsForUser(i));
	}

	private double getMeanRating(List<Rating> ratingList) {
		return ratingList.stream().mapToDouble(r -> r.getScore()).sum() /ratingList.size();
	}
	
	
	private List<Rating> getRatingsForUser(int userId){
		return ratingList.stream().filter(a -> a.getUserId() == userId).collect(Collectors.toList());
	}
	
	
	
	
	

	private static Rating createRating(String[] metadata) {
		int userId = Integer.parseInt(metadata[0]);
		int authorId = Integer.parseInt(metadata[1]);
		double score = Double.parseDouble(metadata[2]);
		return new Rating(userId, authorId, score);
	}


}
