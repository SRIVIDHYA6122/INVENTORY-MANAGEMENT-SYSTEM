package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Customer;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;

	

	@Override
	public List<Customer> selectAllCustomers() {

		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomers(int id) throws CustomerNotFoundException {
		Optional<Customer> customer1= customerRepo.findById(id);
		if(!customer1.isPresent())
		{
			throw new CustomerNotFoundException("Customer id not exists");
		}
		
		return customerRepo.getById(id);
	}

	@Override
	public void deleteCustomerById(int cid) throws CustomerNotFoundException {
		Optional<Customer> customer1= customerRepo.findById(cid);
		if(!customer1.isPresent())
		{
			throw new CustomerNotFoundException("Customer id not exists");
		}
		 customerRepo.deleteById(cid);
		
	}

	@Override
	public Customer updateCustomerById(int id, Customer customer) throws CustomerNotFoundException {
		Optional<Customer> shopkeeper1= customerRepo.findById(id);
		Customer customerDB=null;
		if(shopkeeper1.isPresent()) {
			customerDB=	customerRepo.findById(id).get();
		if(Objects.nonNull(customer.getCustomerName()) && !"".equalsIgnoreCase(customer.getCustomerName())) {
			customerDB.setCustomerName((customer.getCustomerName()));
			
		}
		if(Objects.nonNull(customer.getCustomerMobileNo()) && !"".equalsIgnoreCase(customer.getCustomerMobileNo())) {
			customerDB.setCustomerMobileNo(customer.getCustomerMobileNo());
			System.out.println(customer.getCustomerMobileNo());
		}
		if(Objects.nonNull(customer.getCustomerAddress()) && !"".equalsIgnoreCase(customer.getCustomerAddress())) {
			customerDB.setCustomerAddress(customer.getCustomerAddress());
			System.out.println(customer.getCustomerAddress());
		}
		
	}else
	{
		throw new CustomerNotFoundException("Customer id not exists");
	}
		return customerRepo.save(customerDB);
}}
