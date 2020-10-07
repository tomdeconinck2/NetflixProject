package com.NetflixProject.UserService.model;


/*
 * An AuthUser is a 'standard' user of the application
 */

public class AuthUser extends User{
	
	public AuthUser(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
}
