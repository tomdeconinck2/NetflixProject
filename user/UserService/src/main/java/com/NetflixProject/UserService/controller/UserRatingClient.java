package com.NetflixProject.UserService.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="rating-service")
public interface UserRatingClient {
	
	@GetMapping("/ratingsOfUser/{userId}")
	public List<Object> getRatingsOfUser(@PathVariable("userId") Long userId);
	
	@DeleteMapping("/ratingsOfUser/{userId}")
	public void deleteRatingsOfUser(@PathVariable("userId") Long userId);


}
