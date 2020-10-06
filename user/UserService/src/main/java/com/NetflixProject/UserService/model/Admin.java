package com.NetflixProject.UserService.model;

import org.springframework.stereotype.Component;

/*
 * An Admin is a user that has administrator privileges
 */
@Component
public class Admin extends User{
	
	public Admin(String fName, String lName, String email) {
		super(fName, lName, email);
	}

}
