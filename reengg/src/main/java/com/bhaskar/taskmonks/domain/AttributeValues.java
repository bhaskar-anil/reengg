package com.bhaskar.taskmonks.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tm_atr_values")
public class AttributeValues {
	
	@Id
	@Column(name="atrvalueid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long atrValueId;
	
	@Column(name="atrvalue", length=1000, nullable=true)
	private String atrValue;
	
	@Column(name="price", nullable=true)
	private Integer price=0;
	
	@Column(name="atrvaluetype", length=1000, nullable=true)
	private String atrValueType;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="atrId")
	private TaskAttribute taskAttribute;
	
	public Long getAtrValueId() {
		return atrValueId;
	}

	public void setAtrValueId(Long atrValueId) {
		this.atrValueId = atrValueId;
	}

	public String getAtrValue() {
		return atrValue;
	}

	public void setAtrValue(String atrValue) {
		this.atrValue = atrValue;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public TaskAttribute getTaskAttribute() {
		return taskAttribute;
	}

	public void setTaskAttribute(TaskAttribute taskAttribute) {
		this.taskAttribute = taskAttribute;
	}

	public String getAtrValueType() {
		return atrValueType;
	}

	public void setAtrValueType(String atrValueType) {
		this.atrValueType = atrValueType;
	}

}
