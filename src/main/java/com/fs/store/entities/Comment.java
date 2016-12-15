package com.fs.store.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.COMMENT)
public class Comment {

	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.CUSTOMER_ID)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.PRODUCT_ID)
	private Product product;
	
	@Column(name = DatabaseConstants.COMMENT)
	private String comment;
	
	@Temporal(TemporalType.DATE)
	@Column(name = DatabaseConstants.DATE)
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
