package com.NetflixProject.UserService.model;

/*
 * An AuthUser is a 'standard' user of the application
 */
public class AuthUser extends User{
	
	public AuthUser(String fName, String lName, String email) {
		super(fName, lName, email);
	}
}
