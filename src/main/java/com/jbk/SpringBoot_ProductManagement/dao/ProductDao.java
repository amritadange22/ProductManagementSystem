package com.jbk.SpringBoot_ProductManagement.dao;

import java.util.List;

import com.jbk.SpringBoot_ProductManagement.entity.Product;

public interface ProductDao {

	public Boolean saveProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
	public Boolean deleteProductById(int productId);
	public Boolean updateProduct(Product product);
}
