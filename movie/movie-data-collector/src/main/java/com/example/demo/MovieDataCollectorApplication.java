package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) //TODO
public class MovieDataCollectorApplication {

	public static void main(String[] args) {
		System.out.println(" Runs ");
		SpringApplication.run(MovieDataCollectorApplication.class, args);
		MovieScraperService m = new MovieScraperService();
		m.scrape();
				
				
	}

}
