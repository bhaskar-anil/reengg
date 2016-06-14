package com.bhaskar.taskmonks.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tm_category")
public class Category {
	
	@Id
	@Column(name="catid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catId;
	
	@Column(name="catname", length=100, nullable=true)
	private String catName;
	
	@Column(name="catdesc", length=500, nullable=true)
	private String catDesc;
	
	@Column(name="caticon", length=50, nullable=true)
	private String catIcon;
	
	@Column(name="caturi", length=50)
	private String catUri;
	
	@Column(name="catmenuflag", nullable=true)
	private Boolean catMenuFlag;
	
	@OneToMany(mappedBy="category")
	private Set<Task> tasks;

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catid) {
		this.catId = catid;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catname) {
		this.catName = catname;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catdesc) {
		this.catDesc = catdesc;
	}

	public String getCatIcon() {
		return catIcon;
	}

	public void setCatIcon(String caticon) {
		this.catIcon = caticon;
	}

	public Boolean getCatMenuFlag() {
		return catMenuFlag;
	}

	public void setCatMenuFlag(Boolean catMenuFlag) {
		this.catMenuFlag = catMenuFlag;
	}

	public String getCatUri() {
		return catUri;
	}

	public void setCatUri(String catUri) {
		this.catUri = catUri;
	}
	
	
	
	
}
