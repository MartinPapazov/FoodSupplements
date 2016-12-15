package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.RATING)
public class Rating {
	
	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.USER_ID)
	private Customer user;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.PRODUCT_ID)
	private Product product;
	
	@Column(name = DatabaseConstants.RATING)
	private int rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
