package com.bxa.csa.security.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ACLController {
	
	@Autowired
	JdbcMutableAclService acl;
	
	@RequestMapping("/user/acl/list")
	public String getUserAclListings(){
		
		return "acl_list";
	}
}
