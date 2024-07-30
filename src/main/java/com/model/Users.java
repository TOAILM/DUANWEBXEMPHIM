package com.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@Column(name = "Id")
	String id;
	@Column(name = "Password")
	String password;
	@Column(name = "Fullname")
	String fullname;
	@Column(name = "Email")
	String email;
	@Column(name = "Admin")
	boolean admin = false;
	@Column(name = "PremiumCount")
	Date PremiumCount;
	@OneToMany(mappedBy = "user")
	List<Favorite> favorites;

	public Users(String id, String password, String fullname, String email, boolean admin, Date premiumCount, List<Favorite> favorites) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
		PremiumCount = premiumCount;
		this.favorites = favorites;
	}

	public Users() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getPremiumCount() {
		return PremiumCount;
	}

	public void setPremiumCount(Date premiumCount) {
		PremiumCount = premiumCount;
	}
	
	public List<Favorite> getFavorites()
	{
		return favorites;
	}
	
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
}
