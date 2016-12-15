package com.fs.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.AUTHORITY)
public class Authority {

	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@Column(name = DatabaseConstants.AUTHORITY)
	private String authority;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
