package com.NetflixProject.UserService.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.NetflixProject.UserService.model.User;
import com.NetflixProject.UserService.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		return this.userRepository.findAll();	
	}
	
	public ResponseEntity<User> getUser(Long id) {
		try {
			User u = userRepository.getOne(id);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> addNewUser(User user) {
		if(! userExists(user)){
			this.userRepository.save(user);
			return new ResponseEntity<>("User created",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("A user with this email address already exists",HttpStatus.PRECONDITION_FAILED);
		}
	}
	
	private boolean userExists(User u) {
		// TODO check if email already exists. A user can not have multiple accounts for the same email address
		return false;
	}
	

	public ResponseEntity<String> deleteUser(Long id){
		try {
			this.userRepository.deleteById(id);
			return new ResponseEntity<>("User deleted",HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<>("User did not exist",HttpStatus.NOT_FOUND);
		}
	}
	
	

}
