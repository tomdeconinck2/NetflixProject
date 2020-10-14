package com.NetflixProject.UserService.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NetflixProject.UserService.model.User;
import com.NetflixProject.UserService.services.UserService;

@RestController
public class UserController {
		
	@Autowired
	private UserService userService;
	
	/*
	 * Get a welcome message from the user service
	 */
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to the UserService microservice!";
	}
	
	/*
	 * Get a list of all users in the database
	 */
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();	
	}

	/*
	 * Get the user with given id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	/*
	 * Add the new given user to the database
	 */
	@PostMapping("/addUser")
	public ResponseEntity<String> addNewUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}	

	/*
	 * Delete the user with given id from the database
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		return userService.deleteUser(id);
	}
	
	/*
	 * Get a list of all ratings from the user with given id
	 */
	@GetMapping("/{id}/ratings")
	public ResponseEntity<List<Object>> getRatingsOfUser(@PathVariable("id") Long id){
		return userService.getRatingsOfUser(id);
	}
	
	
}
