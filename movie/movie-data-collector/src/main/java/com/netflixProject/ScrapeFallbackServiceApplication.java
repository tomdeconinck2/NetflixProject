package com.netflixProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
//@ComponentScan({"com.example.demo"})
//@ComponentScan({"com.example.demo.repositories"})
//@EnableJpaRepositories("com.example.demo.repositories")
@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class }) //TODO wanneer componentscan nodig?
public class ScrapeFallbackServiceApplication {

	public static void main(String[] args) {
		System.out.println(" Runs ");
		SpringApplication.run(ScrapeFallbackServiceApplication.class, args);
		MovieScraperService m = new MovieScraperService();
		//m.scrape();
				
				
	}

}
