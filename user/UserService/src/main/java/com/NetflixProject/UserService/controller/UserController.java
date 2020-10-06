package com.NetflixProject.UserService.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to the UserService microservice!";
	}
	
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();	
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Long> addNewUser(@RequestBody User user) {
		boolean isAdded = userService.addNewUser(user);
		if(isAdded) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id){
		boolean isDeleted = userService.deleteUser(id);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
