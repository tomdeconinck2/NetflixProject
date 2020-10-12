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


public class CSVReader {



	public void read() {

		//new CSVRatingHandler().read();
		new CSVMovieHandler().read();

	}


}
