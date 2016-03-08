package com.bxa.csa.dao;

import java.util.Set;

import com.bxa.csa.model.CRole;

public interface CRoleDao {

	public CRole save(CRole cRole);
	public CRole update(CRole cRole);
	public CRole delete(CRole cRole);
	public CRole get(long id);
	public Set<CRole> getAll();
	
}
