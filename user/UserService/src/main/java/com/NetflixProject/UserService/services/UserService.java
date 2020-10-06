package com.NetflixProject.UserService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NetflixProject.UserService.model.User;
import com.NetflixProject.UserService.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		return userRepository.findAll();	
	}
	
	public User getUser(Long id) {
		return userRepository.getOne(id);
	}
	
	public boolean addNewUser(User user) {
		// TODO check if email already exists. A user can not have multiple accounts for the same email address
		userRepository.save(user);
		return true;
	}
	

	public boolean deleteUser(Long id){
		try {
			userRepository.deleteById(id);
			return true;
		}
		catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	

}
