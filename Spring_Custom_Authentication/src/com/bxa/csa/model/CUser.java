package com.bxa.csa.model;

import java.util.Collection;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "CUSER")
public class CUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String username;
	String password;
	@ManyToMany(mappedBy="listOfUser")
	Set<CRole> listOfRoles;

	
	public CUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Set<CRole> getListOfRoles() {
		return listOfRoles;
	}

	public void setListOfRoles(Set<CRole> listOfRoles) {
		this.listOfRoles = listOfRoles;
	}
	
}
