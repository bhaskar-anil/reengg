package com.bhaskar.taskmonks.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tm_task")
public class Task {
	
	@Id
	@Column(name="taskid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long taskId;
	
	@Column(name="taskname", length=256, nullable=true)
	private String taskName;
	
	@Column(name="taskdesc", length=1000, nullable=true)
	private String taskDesc;
	
	@Column(name="taskicon", length=50, nullable=true)
	private String taskIcon;
	
	@Column(name="catid", length=11)
	private Long catId;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskIcon() {
		return taskIcon;
	}

	public void setTaskIcon(String taskIcon) {
		this.taskIcon = taskIcon;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}
	
	

}
