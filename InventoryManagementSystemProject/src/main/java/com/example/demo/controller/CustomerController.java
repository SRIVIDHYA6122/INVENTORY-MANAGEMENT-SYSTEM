package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;

import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer/selectbyid/{id}")
	public Customer getCustomers(@PathVariable ("id") int id) throws CustomerNotFoundException
	{
		return customerService.getCustomers(id);
		
	}
	
	@GetMapping("/customer/selectall/")
	public List<Customer> selectAllProduct()
	{
		return customerService .selectAllCustomers();
		
	}
	
	
	@PutMapping("/customer/updatebyid/{cid}")
	public Customer updateProductById(@PathVariable ("cid") int id, @RequestBody Customer customer) throws CustomerNotFoundException
	{
		return  customerService .updateCustomerById(id,customer);
		
	}
	
	@DeleteMapping("/customer/deletebyid/{cid}")
	public   String deleteCustomerById(@PathVariable ("cid") int cid) throws CustomerNotFoundException
	{
		customerService.deleteCustomerById(cid);
		 return "Product is deleted successfully";
		
	}
	
	
}
