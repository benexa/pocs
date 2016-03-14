package com.bxa.csa.service;

import java.util.Set;

import com.bxa.csa.model.CRole;

public interface RoleService {
	public CRole createRole(CRole crole);
	public CRole updateRole(CRole crole);
	public CRole getRoleById(long id);
	public boolean deleteRole(CRole crole);
	public Set<CRole> getListOfRoles();
}
