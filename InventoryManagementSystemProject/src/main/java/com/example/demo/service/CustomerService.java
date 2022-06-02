package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.error.CustomerNotFoundException;



public interface CustomerService {



	List<Customer> selectAllCustomers();

	Customer getCustomers(int id) throws CustomerNotFoundException;

	void deleteCustomerById(int cid) throws CustomerNotFoundException;

	Customer updateCustomerById(int id, Customer customer) throws CustomerNotFoundException;

}
