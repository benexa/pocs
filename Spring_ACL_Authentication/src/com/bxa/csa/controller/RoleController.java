package com.bxa.csa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bxa.csa.model.CRole;
import com.bxa.csa.service.RoleService;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/form")
	public ModelAndView getUserForm(){
		return new ModelAndView("role_form","role", new CRole());
	} 
	
	
	@RequestMapping("/create")
	public String createNewRole(@ModelAttribute("role")CRole role, ModelMap modelMap){
		CRole newrole = roleService.createRole(role);
		modelMap.addAttribute("role", newrole);
		return "redirect:/admin/role/all";
	}
	
	@RequestMapping("/all")
	public String getAllRoles(ModelMap modelMap){
		Set<CRole> listOfRoles = roleService.getListOfRoles();
		modelMap.addAttribute("roleList", listOfRoles);
		return "roleList";
	}
}
