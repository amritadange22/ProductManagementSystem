package com.jbk.SpringBoot_ProductManagement.customException;

public class ProductAlreadyExistsException extends RuntimeException{

	public ProductAlreadyExistsException (String productId)  
    {  
        // calling the constructor of parent RuntimeException  
        super(productId);  
    }
}
