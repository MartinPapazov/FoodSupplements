package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.ORDER_PER_PRODUCT)
public class OrderPerProduct {

	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.ORDER_ID, nullable=false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.PRODUCT_DETAILS_ID)
	private ProductDetails prdocutDetails;
	
	@Column(name = DatabaseConstants.QUANTITY)
	private int quantity;
	
	@Column(name = DatabaseConstants.PRICE)
	private double price;

	public OrderPerProduct() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductDetails getProductDetails() {
		return prdocutDetails;
	}

	public void setProductDetails(ProductDetails prdocutDetails) {
		this.prdocutDetails = prdocutDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
