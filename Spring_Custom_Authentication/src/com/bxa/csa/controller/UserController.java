package com.bxa.csa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bxa.csa.model.CUser;
import com.bxa.csa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/form")
	public ModelAndView getUserForm(){
		return new ModelAndView("user_form","user", new CUser());
	} 
	
	
	@RequestMapping("/create")
	public String createNewUser(@ModelAttribute("user")CUser cuser, ModelMap modelMap){
		CUser user = userService.createUser(cuser);
		modelMap.addAttribute("user", user);
		return "user";
	}
}
