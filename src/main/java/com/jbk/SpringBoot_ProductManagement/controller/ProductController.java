package com.jbk.SpringBoot_ProductManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.SpringBoot_ProductManagement.customException.ProductAlreadyExistsException;
import com.jbk.SpringBoot_ProductManagement.customException.ProductNotFoundException;
import com.jbk.SpringBoot_ProductManagement.entity.Product;
import com.jbk.SpringBoot_ProductManagement.service.ProductService;

@RestController
@Validated
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value="/saveProduct")
	public ResponseEntity<String> saveProduct(@Valid @RequestBody Product product) {
		Boolean b = service.saveProduct(product);
		
		if(b)
		{
			return new ResponseEntity<String>("Product Saved!!!",HttpStatus.CREATED);
		}
		else
			throw new ProductAlreadyExistsException(String.valueOf(product.getProduct_id()));
	}
	
	@GetMapping(value="/getProductById")
	public ResponseEntity<Product> getProductById(@RequestParam int productId) {
		Product product = service.getProductById(productId);
		String pid=String.valueOf(productId);
		if(product!=null)
		{
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		else
			throw new ProductNotFoundException(pid);
	}
	
	@GetMapping(value="/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = service.getAllProducts();
		
		if(!products.isEmpty())
		{
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/deleteProductById")
	public ResponseEntity<String> deleteProductById(@RequestParam int productId) {
		Boolean b = service.deleteProductById(productId);
		String pid=String.valueOf(productId);
		if(b)
		{
			return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
		}
		else
			throw new ProductNotFoundException(pid);
	}
	
	@PutMapping(value="/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		Boolean b = service.updateProduct(product);
		String pid= String.valueOf(product.getProduct_id());
		
		if(b)
		{
			return new ResponseEntity<String>("Product Updated!!!",HttpStatus.ACCEPTED);
		}
		else
			throw new ProductNotFoundException(pid);
	}
	
	@GetMapping(value="/generateReport")
	public ResponseEntity<String> generateReport(@RequestParam String format){
		String destination = service.generateReport(format);
		return new ResponseEntity<String>(destination,HttpStatus.OK);
	}
}
