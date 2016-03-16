package com.bxa.csa.service;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;

import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;

public interface UserService {
	
	@PreAuthorize("hasPermission(#post, 'CREATE')")
	public CUser createUser(CUser cuser);
	
	@PreAuthorize("hasPermission(#post, 'WRITE')")
	public CUser updateUser(CUser cuser);
	
	@PreAuthorize("hasPermission(#post, 'READ')")
	public CUser getUserById(long id);
	
	@PreAuthorize("hasPermission(#post, 'READ')")
	public CUser getUserByUsername(String username);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public  Set<CRole> getUserRoles(long id);
	
	@PreAuthorize("hasPermission(#post, 'DELETE')")
	public boolean deleteUser(CUser cuser);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Set<CUser> getListOfUsers();
}
