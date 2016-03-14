package com.bxa.csa.dao;

import java.util.Set;

import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;

public interface CUserDao {
	public CUser save(CUser cUser);
	public CUser update(CUser cUser);
	public boolean delete(CUser cUser);
	public CUser get(long id);
	public Set<CRole> getUserRoles(long id);
	public Set<CUser> getAll();
	public CUser getByUserName(String username);
}
