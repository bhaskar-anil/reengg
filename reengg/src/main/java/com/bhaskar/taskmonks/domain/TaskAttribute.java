package com.bhaskar.taskmonks.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tm_task_atr")
public class TaskAttribute {
	
	@Id
	@Column(name="atrid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long atrId;
	
	@Column(name="atrstaement", length=1000, nullable=true)
	private String atrStatement;
	
	@Column(name="atrtype", length=100, nullable=true)
	private String atrType;
	
	@Column(name="step", nullable=true)
	private Integer step;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="taskid")
	private Task task;
	
	@OneToMany(mappedBy="taskAttribute")
	private Set<AttributeValues> atrsValues;

	public Long getAtrId() {
		return atrId;
	}

	public void setAtrId(Long atrId) {
		this.atrId = atrId;
	}

	public String getAtrStatement() {
		return atrStatement;
	}

	public void setAtrStatement(String atrStatement) {
		this.atrStatement = atrStatement;
	}

	public String getAtrType() {
		return atrType;
	}

	public void setAtrType(String atrType) {
		this.atrType = atrType;
	}
	
	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
