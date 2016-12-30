package com.bhaskar.taskmonks.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tasker_details")
public class TaskerDetails implements Serializable{
	
	@Id
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="userid")
	private User user;
	
	@Column(name="about", length=256)
	private String about;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="location")
	private String location;
	
	@Column(name="skills", length=500)
	private String skills;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	

}
