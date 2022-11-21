package com.jbk.SpringBoot_ProductManagement.customException;

public class ProductNotFoundException extends RuntimeException{

	 public ProductNotFoundException (String productId)  
	    {  
	        // calling the constructor of parent RuntimeException  
	        super(productId);  
	    }  
}
