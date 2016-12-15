package com.fs.store.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fs.store.constants.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.USER)
public class Customer {

	@Id
	@Column(name = DatabaseConstants.ID)
	private int id;
	
	@Column(name = DatabaseConstants.USERNAME)
	private String username;
	
	@Column(name = DatabaseConstants.PASSWORD)
	private String password;
	
	@Column(name = DatabaseConstants.EMAIL)
	private String email;
	
	@Column(name = DatabaseConstants.FIRST_NAME)
	private String firstName;
	
	@Column(name = DatabaseConstants.LAST_NAME)
	private String lastName;
	
	@Column(name = DatabaseConstants.GENDER)
	private String gender;
	
	@Column(name = DatabaseConstants.BIRTH_DATE)
	private Date birthDate;
	
	@Column(name = DatabaseConstants.CITY)
	private String city;
	
	@Column(name = DatabaseConstants.IMAGE)
	private byte[] image;

	@Temporal(TemporalType.DATE)
	@Column(name = DatabaseConstants.CREATED)
	private Date created;
	
	@Column(name = DatabaseConstants.STATUS)
	private String isActive;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = DatabaseConstants.USER_AUTHO, joinColumns = {
			@JoinColumn(name = DatabaseConstants.USER_ID, referencedColumnName = DatabaseConstants.ID)}, inverseJoinColumns = {
					@JoinColumn(name = DatabaseConstants.AUTHO_ID, referencedColumnName = DatabaseConstants.ID)
			})
	private List<Authority> authorities;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public List<Authority> getAuthorities() {
		return this.authorities;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
