package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	Product findByProductID(int productID);
	
//	List<Product> findByProductName(String productName);
	
	Product save(Product product);
	
	void deleteById(int id);
	
}
