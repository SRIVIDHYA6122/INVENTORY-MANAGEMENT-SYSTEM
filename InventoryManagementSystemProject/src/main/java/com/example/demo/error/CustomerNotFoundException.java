package com.example.demo.error;


public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(String s)
	{
		super(s);
	}
	

}
