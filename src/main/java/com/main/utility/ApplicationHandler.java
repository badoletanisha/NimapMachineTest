package com.main.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.main.exception.CategoryNotFoundException;
import com.main.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> categoryNotFoundException(CategoryNotFoundException ex)
	{
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMsg());
		errorStructure.setErrorData("Category Object With the Gven id Doesn't Exist");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundException(ProductNotFoundException ex)
	{
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMsg());
		errorStructure.setErrorData("Product Object With the Gven id Doesn't Exist");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
}
