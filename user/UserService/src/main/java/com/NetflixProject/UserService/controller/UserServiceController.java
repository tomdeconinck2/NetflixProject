package com.NetflixProject.UserService.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/welcome2")
	public String welcome2(){
		return "Welcome 2";
		
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userRepository.getOne(id);
	}
	
	@GetMapping("/user/{id}/getFirstName")
	public String getUserFirstName(@PathVariable("id") Long id) {
		User u = userRepository.getOne(id);
		return u.getFirstName();
	}
	
	@PostMapping("/user/{id}/setFirstName")
	public void setUserFirstName(@PathVariable("id") Long id, @RequestParam("name") String newName) {
		User u = userRepository.getOne(id);
		u.setFirstName(newName);
	}
	
	@GetMapping("/user/{id}/getLasttName")
	public String getUserLastName(@PathVariable("id") Long id) {
		User u = userRepository.getOne(id);
		return u.getLastName();
	}
	
	@PostMapping("/user/{id}/setLastName")
	public void setUserLastName(@PathVariable("id") Long id, @RequestParam("name") String newName) {
		User u = userRepository.getOne(id);
		u.setLastName(newName);
	}
	
	@PostMapping("addUser")
	public void addNewUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
