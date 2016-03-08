package com.bxa.csa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CRole {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String role;
	String description;
	@ManyToMany
	Set<CUser> listOfUser; 
	
	public CRole(long id, String role, String description) {
		super();
		this.id = id;
		this.role = role;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<CUser> getListOfUser() {
		return listOfUser;
	}

	public void setListOfUser(Set<CUser> listOfUser) {
		this.listOfUser = listOfUser;
	}
	
		
}
