package com.NetflixProject.UserService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public abstract class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private final Date dateCreated = new Date();
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private Date dateLastChanged = new Date();
	
	
	public User(String fName, String lName, String email) {
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
	}
	
	/*
	 * Getters and setters for the above variables
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		this.dateLastChanged = new Date();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		this.dateLastChanged = new Date();
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.dateLastChanged = new Date();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		this.dateLastChanged = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Date getDateLastChanged() {
		return dateLastChanged;
	}
	
	
}
