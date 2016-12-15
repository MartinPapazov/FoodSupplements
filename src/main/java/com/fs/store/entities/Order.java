package com.fs.store.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.ORDER)
public class Order {
	
	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstants.CUSTOMER_ID)
	private Customer user;
	
	@Column(name = DatabaseConstants.DATE)
	private Date date;
	
	@Column(name = DatabaseConstants.STATUS)
	private String status;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
