package com.bxa.csa.service;

import java.util.Set;

import com.bxa.csa.model.CUser;

public interface UserService {
	public CUser createUser(CUser cuser);
	public CUser updateUser(CUser cuser);
	public CUser getUserById(long id);
	public boolean deleteUser(CUser cuser);
	public Set<CUser> getListOfUsers();
}
