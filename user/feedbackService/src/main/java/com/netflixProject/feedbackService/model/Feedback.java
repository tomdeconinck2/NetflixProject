package com.netflixProject.feedbackService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Feedback")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long user_id;
	
	//TODO is a string for now. Maybe has to be changed to a form with some fields for easier analysis
	private String description;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private final Date dateCreated = new Date();
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
	private Date dateLastChanged = new Date();
	
	
	
	public Feedback(Long userId, String description) {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.setDateLastChanged(new Date());
		this.id = id;
	}


	public Long getUserID() {
		return user_id;
	}


	public void setUserID(Long userID) {
		this.setDateLastChanged(new Date());
		this.user_id = userID;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.setDateLastChanged(new Date());
		this.description = description;
	}


	public Date getDateLastChanged() {
		return dateLastChanged;
	}


	public void setDateLastChanged(Date dateLastChanged) {
		this.dateLastChanged = dateLastChanged;
	}


	public Date getDateCreated() {
		return dateCreated;
	}
	
	
}
