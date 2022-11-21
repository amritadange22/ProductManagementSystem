package com.jbk.SpringBoot_ProductManagement.customException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> anyNameMethod (ProductNotFoundException ex)
	{
		ErrorDetails details = new ErrorDetails(ex.getMessage(),"Product not found for this product id");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> ProductAlreadyExistsException (ProductAlreadyExistsException ex)
	{
		ErrorDetails details = new ErrorDetails(ex.getMessage(),"Product already exists");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.IM_USED);
	}
	
	@Override
	   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                 HttpHeaders headers, HttpStatus status, WebRequest request) {
	          String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	          List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(Collectors.toList());
	         ApiError apiError = new ApiError();
	         apiError.setErrorMsg(errorMessage);
	         apiError.setList(validationList);
	          return new ResponseEntity<>(apiError, status);
	   }

}