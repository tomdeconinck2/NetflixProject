package com.NetflixProject.UserService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private userType userType;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private final Date dateCreated = new Date();	
	
	
	public User(String fName, String lName, String email) {
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
		
		//A new user is standard a user of type AUTHENTICATED
		this.userType = com.NetflixProject.UserService.model.userType.AUTHENTICATED;
	}
	
	/*
	 * Getters and setters for the above variables
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public userType getUserType() {
		return userType;
	}
	public void setUserType(userType userType) {
		this.userType = userType;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	
	
}
