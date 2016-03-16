package com.lsam.cont;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lsam.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@RequestMapping("/form")
	public ModelAndView getProductForm(){
		return new ModelAndView("productForm", "product",new Product());
	}
	
	@RequestMapping("/create")
	public String createProductForm(@ModelAttribute("product") @Valid Product product, 
									BindingResult results,
									Model model){
		
		model.addAttribute("product", product);
		
		if(results.hasErrors()){
			return "productForm";
		}
		
		return "product";
	}
}
