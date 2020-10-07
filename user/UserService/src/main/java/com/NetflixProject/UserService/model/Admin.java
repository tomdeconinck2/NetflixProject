package com.NetflixProject.UserService.model;


/*
 * An Admin is a user that has administrator privileges
 */

public class Admin extends User{
	
	public Admin(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

}
