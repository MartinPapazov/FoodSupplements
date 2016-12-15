package com.fs.store.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.PRODUCT)
public class Product {
	
	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;

	@ManyToOne
	@JoinColumn(name = DatabaseConstants.SUBCATEGORY_ID)
	private Subcategory subcategery;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.BRAND_ID)
	private Brand brand;
	
	@Column(name = DatabaseConstants.NAME)
	private String name;
	
	@Column(name = DatabaseConstants.SUPPLEMENTS)
	private String supplements;
	
	@Column(name = DatabaseConstants.DESCRIPTION)
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = DatabaseConstants.PRODUCT_PER_TASTE, joinColumns = {
			@JoinColumn(name = DatabaseConstants.PRODUCT_ID, referencedColumnName = DatabaseConstants.ID)}, inverseJoinColumns = {
					@JoinColumn(name = DatabaseConstants.TASTE_ID, referencedColumnName = DatabaseConstants.ID)
			})
	private List<ProductTaste> tastes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subcategory getSubcategery() {
		return subcategery;
	}

	public void setSubcategery(Subcategory subcategery) {
		this.subcategery = subcategery;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplements() {
		return supplements;
	}

	public void setSupplements(String supplements) {
		this.supplements = supplements;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<ProductTaste> getTastes() {
		return tastes;
	}

	public void setTastes(List<ProductTaste> tastes) {
		this.tastes = tastes;
	}	
}
