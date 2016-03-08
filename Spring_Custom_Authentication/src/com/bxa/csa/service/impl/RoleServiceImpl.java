package com.bxa.csa.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bxa.csa.dao.CRoleDao;
import com.bxa.csa.model.CRole;
import com.bxa.csa.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	CRoleDao roleDao;
	
	@Override
	public CRole createRole(CRole crole) {
		return roleDao.save(crole);
	}

	@Override
	public CRole updateRole(CRole crole) {
		return roleDao.update(crole);
	}

	@Override
	public CRole getRoleById(long id) {
		return roleDao.get(id);
	}

	@Override
	public boolean deleteRole(CRole crole) {
		return roleDao.delete(crole);
	}

	@Override
	public Set<CRole> getListOfRoles() {
		return roleDao.getAll();
	}
	
}
