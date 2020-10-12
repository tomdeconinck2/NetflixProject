package com.NetflixProject.UserService.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.NetflixProject.UserService.controller.UserRatingClient;
import com.NetflixProject.UserService.model.User;
import com.NetflixProject.UserService.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRatingClient urc;
	
	
	public List<User> getAllUsers() {
		return this.userRepository.findAll();	
	}
	
	public ResponseEntity<User> getUser(Long id) {
		try {
			User u = this.userRepository.getOne(id);
			return new ResponseEntity<User>(u,HttpStatus.OK);
		}
		catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> addNewUser(User user) {
		if(! userExists(user)){
			this.userRepository.save(user);
			return new ResponseEntity<String>("User created",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("A user with this email address already exists",HttpStatus.PRECONDITION_FAILED);
		}
	}	

	public ResponseEntity<String> deleteUser(Long id){
		try {
			//TODO also delete all the users Ratings, feedbacks and subscriptions
			this.userRepository.deleteById(id);
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<String>("User did not exist",HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<String> changeEmail(Long id, String newEmail){
		if(!emailExists(newEmail)) {
			User user = this.userRepository.getOne(id);
			user.setEmail(newEmail);
			return new ResponseEntity<String>("Changed the email adress", HttpStatus.OK);
		}
		return new ResponseEntity<String>("The given email address is already assigned to a user", HttpStatus.PRECONDITION_FAILED);
	}
	
	
	public ResponseEntity<String> getRatingsOfUser(Long id){
		if(userExists(id)) {
			String ratings = this.urc.getRatingsOfUser(id);			
			return new ResponseEntity<String>(ratings, HttpStatus.OK);
		}
		return new ResponseEntity<String>("The given user does not exist", HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 * Check if the email already exists
	 */
	private boolean emailExists(String email) {
		List<User> users = this.getAllUsers();
		for(User currentUser : users) {
			if(User.emailExists(currentUser.getEmail(), email)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Check if the given id belongs to a user
	 */
	private boolean userExists(Long id) {
		List<User> users = this.getAllUsers();
		for(User user : users) {
			if(user.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * Check if the given user already exists in the repository
	 */
	private boolean userExists(User otherUser) {
		List<User> users = this.getAllUsers();
		for(User currentUser : users) {
			if(User.equals(currentUser, otherUser)) {
				return true;
			}
		}
		return false;
	}

}