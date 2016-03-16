package com.bxa.csa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;

import com.bxa.csa.model.CRole;
import com.bxa.csa.model.CUser;
import com.bxa.csa.service.UserService;

public class Custom_Authentication_Provider implements AuthenticationProvider{

	@Autowired
	UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication,
//				messages.getMessage(
//						"AbstractUserDetailsAuthenticationProvider.onlySupports",
//						"Only UsernamePasswordAuthenticationToken is supported"));

		// Determine username
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED"	: authentication.getName();

		CUser user = userService.getUserByUsername(username);

		if (user == null) {
			throw new BadCredentialsException(username+" not found");
		}
		
		if(authentication.getCredentials()==null||!authentication.getCredentials().equals(user.getPassword())){
			throw new BadCredentialsException("Password not matched");
		}
		
		Object principalToReturn = user.getUsername();

		return createSuccessAuthentication(principalToReturn, authentication, user);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication));
	}
	
	protected Authentication createSuccessAuthentication(Object principal,
			Authentication authentication, CUser user) {
		// Ensure we return the original credentials the user supplied,
		// so subsequent attempts are successful even with encoded passwords.
		// Also ensure we return the original getDetails(), so that future
		// authentication events after cache expiry contain the details
		GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
		
		//fetching the custom roles are parsing them into a collection of authorities 
		Set<CRole> roles = userService.getUserRoles(user.getId());
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(CRole role:roles){
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
				principal, authentication.getCredentials(),
				authoritiesMapper.mapAuthorities(authorities));
		result.setDetails(authentication.getDetails());

		return result;
	}

}
