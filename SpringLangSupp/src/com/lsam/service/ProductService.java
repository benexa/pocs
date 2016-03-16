package com.lsam.service;

import java.util.List;

import com.lsam.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProduct(Product product);
	public List<Product> getAllProduct(Product product);
	public Product deleteProduct(Product product);

}
