package com.NetflixProject.UserService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String first_name;
	private String last_name;
	private String email;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private final Date date_created = new Date();
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private Date date_last_changed = new Date();
	
	
	public User() {
	}
	
	public User(String firstName, String lastName, String email) {
		this.first_name = firstName;
		this.last_name = lastName;
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
		this.setDateLastChanged(new Date());
	}
	
	public String getName() {
		return first_name;
	}
	
	public void setName(String name) {
		this.first_name = name;
		this.setDateLastChanged(new Date());
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		//TODO check if email doesn't already exists in the repository
		this.email = email;
		this.setDateLastChanged(new Date());
	}
	
	public Date getDateCreated() {
		return date_created;
	}
	
	public Date getDateLastChanged() {
		return date_last_changed;
	}
	
	public void setDateLastChanged(Date dateLastChanged) {
		this.date_last_changed = dateLastChanged;
	}	
	
	
}
