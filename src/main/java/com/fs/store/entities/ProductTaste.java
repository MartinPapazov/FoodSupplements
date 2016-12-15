package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.PRODUCT_TASTE)
public class ProductTaste {
	
	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@Column(name = DatabaseConstants.NAME)
	private String name;

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
	
	
}
