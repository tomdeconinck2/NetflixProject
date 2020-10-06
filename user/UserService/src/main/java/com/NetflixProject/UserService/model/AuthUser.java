package com.NetflixProject.UserService.model;

import org.springframework.stereotype.Component;

/*
 * An AuthUser is a 'standard' user of the application
 */
@Component
public class AuthUser extends User{
	
	public AuthUser(String fName, String lName, String email) {
		super(fName, lName, email);
	}
}
