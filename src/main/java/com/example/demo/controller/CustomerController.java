package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerServiceImp;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImp customerServiceImp;

	/*************** Get Methods ******************/

	// get all customer
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomer() {		
		return new ResponseEntity<>(customerServiceImp.findAll(), HttpStatus.OK);
	}

	// get a customer by customerID
	@RequestMapping(value = "/{customerID}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerByID(@PathVariable(name = "customerID") Integer customerID) {
		return new ResponseEntity<>(customerServiceImp.findByCustomerID(customerID), HttpStatus.OK);
	}

//	// get customers by customerName
//	@RequestMapping(value = "/{customerName}", method = RequestMethod.GET)
//	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable(name = "customerName") String customerName) {
//		return new ResponseEntity<>(customerServiceImp.findByCustomerName(customerName), HttpStatus.OK);
//	}

	/******************* Post Methods *************************/

	// save a customer
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerServiceImp.save(customer), HttpStatus.CREATED);
	}

	/************** Delete Methods ********************/
	
//	//delete all customers
//	@RequestMapping(value = "/customer", method = RequestMethod.DELETE)
//	public void deleteCustomers() {
//		customerServiceImp.deleteAll();
//	}
	
	// delete a customer by customerID
	@RequestMapping(value = "/{customerID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomerID(@PathVariable(name = "customerID") Integer customerID) {
		customerServiceImp.deleteById(customerID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/***************** Put Methods ********************/
	
	//update a customer
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer) {
		Customer customerUpdate =  customerServiceImp.save(customer);
		return new ResponseEntity<>(customerUpdate, HttpStatus.OK);
	}

}
