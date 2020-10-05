package com.NetflixProject.UserService.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NetflixProject.UserService.model.User;
import com.NetflixProject.UserService.repositories.UserServiceRepository;

@RestController
public class UserServiceController {
	
	@Autowired
	private UserServiceRepository userRepository;
	
	@GetMapping()
	public String welcomeMessage() {
		return "Welcome to the UserService microservice!";
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userRepository.getOne(id);
	}
	
	@PostMapping("/addUser")
	public void addNewUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
