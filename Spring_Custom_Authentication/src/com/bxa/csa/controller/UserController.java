package com.bxa.csa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bxa.csa.model.CUser;
import com.bxa.csa.service.RoleService;
import com.bxa.csa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/form")
	public String getUserForm(ModelMap modelMap){
		modelMap.addAttribute("roleList", roleService.getListOfRoles());
		modelMap.addAttribute("user", new CUser());
		return "user_form";
	} 
	
	
	@RequestMapping("/create")
	public String createNewUser(@ModelAttribute("user") @Valid CUser cuser, BindingResult result, ModelMap modelMap){
		if(result.hasErrors()){
			System.out.println(result);
		}
		CUser user = userService.createUser(cuser);
		modelMap.addAttribute("user", user);
		return "user";
	}
}
