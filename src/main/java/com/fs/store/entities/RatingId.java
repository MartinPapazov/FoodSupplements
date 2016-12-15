package com.fs.store.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RatingId {

	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Product product;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
