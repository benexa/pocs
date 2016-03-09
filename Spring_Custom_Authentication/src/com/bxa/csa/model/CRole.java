package com.bxa.csa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class CRole {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String role;
	String description;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="CUSER_ROLE", joinColumns={@JoinColumn(name="ROLE_ID",nullable=false)},
	   inverseJoinColumns={@JoinColumn(name="USER_ID",nullable=false)})
	Set<CUser> listOfUser; 
	
	public CRole() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CRole other = (CRole) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CRole [id=" + id + ", role=" + role + ", description=" + description + "]";
	}
	
	
		
}
