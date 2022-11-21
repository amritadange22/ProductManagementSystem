package com.jbk.SpringBoot_ProductManagement.service;

import java.util.List;

import com.jbk.SpringBoot_ProductManagement.entity.Product;

public interface ProductService {

	public Boolean saveProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
	public Boolean deleteProductById(int productId);
	public Boolean updateProduct(Product product);
	public String generateReport(String format);
}