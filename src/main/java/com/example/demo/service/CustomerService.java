package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	
	Customer findByCustomerID(int customerID);
	
//	List<Customer> findByCustomerName(String customerName);
	
	Customer save(Customer customer);
	
//	void deleteAll();
	
	void deleteById(int id);
	
}
