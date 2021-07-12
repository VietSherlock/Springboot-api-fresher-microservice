package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService{
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	/**************Read customer Methods****************/
	
	//get all customers
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}
	
	//get a customer by customerID
	public Customer findByCustomerID(int customerID) {
		return customerRepository.findByCustomerID(customerID);
	}
	
	
	/*****************Save customer Methods*********************/
	
	//save a customer
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	/********************Delete Customer Methods**********************************/
	
//	//delete all customers
//	public void deleteAll() {
//		customerRepository.deleteAll();
//	}
	
	//delete customer by customerID
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}
	
	
	/*********************Update Customer Methods***********************************/
	
	//update a customer
//	@Override
//	public void updateCustomer(String customerName, int customerID) {
//		customerRepository.updateCustomer(customerName, customerID);
//	}

	

}
