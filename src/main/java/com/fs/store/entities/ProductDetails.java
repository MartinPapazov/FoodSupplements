package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.PRODUCT_DETAILS)
public class ProductDetails {
	
	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.PRODUCT_ID)
	private Product product;
	
	@Column(name = DatabaseConstants.QUANTITY)
	private String quantity;
	
	@Column(name = DatabaseConstants.IMAGE)
	private byte[] image;
	
	@Column(name = DatabaseConstants.CURRENT_PRICE)
	private double currentPrice;
	
	@Column(name = DatabaseConstants.OLD_PRICE)
	private double oldPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
}
