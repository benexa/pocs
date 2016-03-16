package com.bxa.csa.security.acl;

import org.springframework.security.acls.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;
import org.springframework.stereotype.Service;

import com.bxa.csa.model.CUser;

@Service
public class UserAclHandler {
	
	@Autowired
	JdbcMutableAclService aclService;
	
	public void initializeDefaultAclPermissions(CUser user){
		// Prepare the information we'd like in our access control entry (ACE)
		ObjectIdentity oi = new ObjectIdentityImpl(CUser.class, user.getId());
		Sid ROLE_ADMIN = new PrincipalSid("ROLE_ADMIN");
		//Permission p = BasePermission.ADMINISTRATION;
		Sid username = new PrincipalSid(user.getUsername());
		// Create or update the relevant ACL
		MutableAcl acl = null;
		try {
		  acl = (MutableAcl) aclService.readAclById(oi);
		} catch (NotFoundException nfe) {
		  acl = aclService.createAcl(oi);
		}

		acl.insertAce(acl.getEntries().size(), BasePermission.READ, username, true);
		acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, username, true);
		
		// Now grant some permissions via an access control entry (ACE)
		acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, ROLE_ADMIN, true);
		acl.insertAce(acl.getEntries().size(), BasePermission.READ, ROLE_ADMIN, true);
		acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, ROLE_ADMIN, true);
		acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, ROLE_ADMIN, true);
		aclService.updateAcl(acl);

	}
	
}
