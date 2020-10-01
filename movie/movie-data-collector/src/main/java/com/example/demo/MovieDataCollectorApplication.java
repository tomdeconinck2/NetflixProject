package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieDataCollectorApplication {

	public static void main(String[] args) {
		System.out.println(" Runs ");
		//SpringApplication.run(MovieDataCollectorApplication.class, args);
		new MovieScraperService().start();
	}

}
