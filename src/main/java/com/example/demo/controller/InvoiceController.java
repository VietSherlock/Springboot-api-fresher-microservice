package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceServiceImp;

@RestController
@RequestMapping("api/v1/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceServiceImp invoiceServiceImp;

	/*************** Get Methods ******************/

	// get all invoice
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getAllInvoice() {
		return new ResponseEntity<>(invoiceServiceImp.findAll(), HttpStatus.OK);
	}

	// get a invoice by invoiceID
	@RequestMapping(value = "/{invoiceID}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> getInvoiceByID(@PathVariable(name = "invoiceID") Integer invoiceID) {
		return new ResponseEntity<>(invoiceServiceImp.findByInvoiceID(invoiceID), HttpStatus.OK);
	}

	/******************* Post Methods *************************/

	// save a invoice
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Invoice> postCustomer(@RequestBody Invoice invoice) {
		return new ResponseEntity<>(invoiceServiceImp.save(invoice), HttpStatus.CREATED);
	}

	/************** Delete Methods ********************/

	// delete a invoice by invoiceID
	@RequestMapping(value = "/{invoiceID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteInvoiceID(@PathVariable(name = "invoiceID") Integer invoiceID) {
		invoiceServiceImp.deleteById(invoiceID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/***************** Put Methods ********************/

	// update a invoice
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice) {
		Invoice invoiceUpdate = invoiceServiceImp.save(invoice);
		return new ResponseEntity<>(invoiceUpdate, HttpStatus.OK);
	}
}
