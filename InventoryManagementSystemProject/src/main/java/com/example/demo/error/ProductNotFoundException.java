package com.example.demo.error;


public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String s)
	{
		super(s);
	}
	

}
