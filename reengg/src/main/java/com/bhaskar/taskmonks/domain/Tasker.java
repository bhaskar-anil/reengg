package com.bhaskar.taskmonks.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tm_tasker")
public class Tasker {
	
	@Id
	@Column(name="taskerid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long taskerId;
	
	@Column(name="taskername")
	private String taskerName;
	
	@Column(name="taskerpassword")
	private String taskerPassword;
	
	@Column(name="taskerenabled")
	private Boolean taskerEnabled;
	
	@Column(name="taskeremail")
	private String taskerEmail;
	
	@Column(name="taskerphone")
	private String taskerPhone;

	@Column(name="taskerexpertise")
	private String taskerExpertise;
	
	@Column(name="taskeroexpertise")
	private String otherExpertise;

	public Long getTaskerId() {
		return taskerId;
	}

	public void setTaskerId(Long taskerId) {
		this.taskerId = taskerId;
	}

	public String getTaskerName() {
		return taskerName;
	}

	public void setTaskerName(String taskerName) {
		this.taskerName = taskerName;
	}

	public String getTaskerPassword() {
		return taskerPassword;
	}

	public void setTaskerPassword(String taskerPassword) {
		this.taskerPassword = taskerPassword;
	}

	public Boolean getTaskerEnabled() {
		return taskerEnabled;
	}

	public void setTaskerEnabled(Boolean taskerEnabled) {
		this.taskerEnabled = taskerEnabled;
	}

	public String getTaskerEmail() {
		return taskerEmail;
	}

	public void setTaskerEmail(String taskerEmail) {
		this.taskerEmail = taskerEmail;
	}

	public String getTaskerExpertise() {
		return taskerExpertise;
	}

	public void setTaskerExpertise(String taskerExpertise) {
		this.taskerExpertise = taskerExpertise;
	}

	public String getOtherExpertise() {
		return otherExpertise;
	}

	public void setOtherExpertise(String otherExpertise) {
		this.otherExpertise = otherExpertise;
	}	
	
	public String getTaskerPhone() {
		return taskerPhone;
	}

	public void setTaskerPhone(String taskerPhone) {
		this.taskerPhone = taskerPhone;
	}

	public Tasker(String taskerName, String taskerPassword, Boolean taskerEnabled, String taskerEmail,
			String taskerExpertise, String otherExpertise, String taskerPhone) {
		super();
		this.taskerName = taskerName;
		this.taskerPassword = taskerPassword;
		this.taskerEnabled = taskerEnabled;
		this.taskerEmail = taskerEmail;
		this.taskerExpertise = taskerExpertise;
		this.otherExpertise = otherExpertise;
		this.taskerPhone = taskerPhone;
	}

}
