package com.lsam.dao;

import com.lsam.model.Product;

public interface ProductDao {
	public Product create(Product product);
	public Product read(Product product);
	public Product update(Product product);
	public Product delete(Product product);
}
