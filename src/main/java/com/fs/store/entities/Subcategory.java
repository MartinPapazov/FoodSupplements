package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.SUBCATEGORY)
public class Subcategory {

	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.CATEGORY_ID)
	private Category category;
	
	@Column(name = DatabaseConstants.NAME)
	private String name;
	
	@Column(name = DatabaseConstants.DESCRIPTION)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
