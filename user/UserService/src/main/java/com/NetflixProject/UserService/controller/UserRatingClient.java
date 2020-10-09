package com.NetflixProject.UserService.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="rating-service")
public interface UserRatingClient {
	
	@GetMapping("/ratingsOfUser/{userId}")
	public String getRatingsOfUser(@PathVariable("userId") Long userId);

}
