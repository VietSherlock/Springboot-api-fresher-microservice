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
import com.example.demo.entity.InvoiceDetail;
import com.example.demo.service.InvoiceDetailServiceImp;

@RestController
@RequestMapping("/invoiceDetail")
public class InvoiceDetailController {

	@Autowired
	private InvoiceDetailServiceImp invoiceDetailServiceImp;

	/*************** Get Methods ******************/

	// get all invoiceDetail
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<InvoiceDetail>> getAllInvoiceDetail() {
		return new ResponseEntity<>(invoiceDetailServiceImp.findAll(), HttpStatus.OK);
	}

	// get a invoiceDetail by invoiceDetailID
	@RequestMapping(value = "/{invoiceDetailID}", method = RequestMethod.GET)
	public ResponseEntity<InvoiceDetail> getInvoiceDetailByID(@PathVariable(name = "invoiceDetailID") Integer invoiceDetailID) {
		return new ResponseEntity<>(invoiceDetailServiceImp.findByInvoiceDetailID(invoiceDetailID), HttpStatus.OK);
	}

	/******************* Post Methods *************************/

	// save a invoiceDetail
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<InvoiceDetail> postInvoidDetail(@RequestBody InvoiceDetail invoiceDetail) {
		return new ResponseEntity<>(invoiceDetailServiceImp.save(invoiceDetail), HttpStatus.CREATED);
	}

	/************** Delete Methods ********************/

	// delete a invoiceDetail by invoiceDetailID
	@RequestMapping(value = "/{invoiceDetailID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteInvoiceDetailID(@PathVariable(name = "invoiceDetailID") Integer invoiceDetailID) {
		invoiceDetailServiceImp.deleteById(invoiceDetailID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/***************** Put Methods ********************/

	// update a invoiceDetail
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<InvoiceDetail> updateInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail) {
		InvoiceDetail invoiceDetailUpdate = invoiceDetailServiceImp.save(invoiceDetail);
		return new ResponseEntity<>(invoiceDetailUpdate, HttpStatus.OK);
	}

}
