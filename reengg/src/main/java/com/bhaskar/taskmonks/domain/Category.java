package com.bhaskar.taskmonks.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tm_category")
public class Category {
	
	@Id
	@Column(name="catid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catid;
	
	@Column(name="catname", length=100, nullable=true)
	private String catname;
	
	@Column(name="catdesc", length=500, nullable=true)
	private String catdesc;
	
	@Column(name="caticon", length=50, nullable=true)
	private String caticon;

	public Long getCatid() {
		return catid;
	}

	public void setCatid(Long catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}

	public String getCaticon() {
		return caticon;
	}

	public void setCaticon(String caticon) {
		this.caticon = caticon;
	}	
}
