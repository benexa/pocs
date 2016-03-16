package com.lsam.cont;

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
	public String createProductForm(@ModelAttribute("product")Product product, 
									BindingResult results,
									Model model){
		if(results.hasErrors()){
			model.addAttribute("product", product);
			return "productForm";
		}
		return "product";
	}
}
