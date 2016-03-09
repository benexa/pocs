package com.bxa.csa.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="CUSER_ROLE", joinColumns={@JoinColumn(name="USER_ID",nullable=false)},
						   inverseJoinColumns={@JoinColumn(name="ROLE_ID",nullable=false)})
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		CUser other = (CUser) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
