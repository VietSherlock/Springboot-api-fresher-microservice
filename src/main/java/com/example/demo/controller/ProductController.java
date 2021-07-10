package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductServiceImp;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServiceImp productServiceImp;

	/******************** Get Product Method ***********************/

	// get all products
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		return productServiceImp.findAll();
	}

	// get a product by productID
	// get a customer by customerID
	@RequestMapping(value = "/{productID}", method = RequestMethod.GET)
	public Product getProductByID(@PathVariable(name = "productID") Integer productID) {
		return productServiceImp.findByProductID(productID);
	}

	/*********************** POST Product Method ********************************/

	// save a product
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void postCustomer(@RequestBody Product product) {
		productServiceImp.save(product);
	}

	/***************** Put Methods ********************/

	// update a customer
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Product>updateProduct(@RequestBody Product product) {
		Product productUpdate =  productServiceImp.save(product);
		return new ResponseEntity<>(productUpdate, HttpStatus.OK);
	}

	/***************** Delete Methods ********************/
	
	// delete a product by productID
	@RequestMapping(value = "/{productID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductID(@PathVariable(name = "productID") Integer productID) {
		productServiceImp.deleteById(productID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
