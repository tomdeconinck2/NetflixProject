package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) //TODO replace
@SpringBootApplication 
public class TrainingServiceApplication {


	public static void main(String[] args) {
		System.out.println("TrainingService Runs ");
		new CSVReader().read();
		SpringApplication.run(TrainingServiceApplication.class, args);
		System.out.println("Finished reading ");
	}

}
