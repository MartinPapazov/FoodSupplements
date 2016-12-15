package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.CATEGORY)
public class Category {

	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
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
