package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvoiceDetail;
import com.example.demo.repository.InvoiceDetailRepository;

@Service
public class InvoiceDetailServiceImp implements InvoiceDetailService {

	private final InvoiceDetailRepository invoiceDetailRepository;

	@Autowired
	public InvoiceDetailServiceImp(InvoiceDetailRepository invoiceDetailRepository) {
		super();
		this.invoiceDetailRepository = invoiceDetailRepository;
	}

	/************** Read InvoiceDetail Methods ****************/

	// get all invoicesDetail
	public List<InvoiceDetail> findAll() {
		return (List<InvoiceDetail>) invoiceDetailRepository.findAll();
	}

	// get a invoicesDetail by invoiceDetailID
	public InvoiceDetail findByInvoiceDetailID(int invoiceDetailID) {
		return invoiceDetailRepository.findByInvoiceDetailID(invoiceDetailID);
	}

	/***************** Save InvoiceDetail Methods *********************/

	// save a invoiceDetail
	public InvoiceDetail save(InvoiceDetail invoiceDetail) {
		return invoiceDetailRepository.save(invoiceDetail);
	}

	/********************
	 * Delete InvoiceDetail Methods
	 **********************************/

	// delete invoiceDetail by invoiceDetailID
	public void deleteById(int id) {
		invoiceDetailRepository.deleteById(id);
	}

	/*********************
	 * Update InvoiceDetail Methods
	 ***********************************/

//	update a invoiceDetail
	public void updateInvoiceDetail(InvoiceDetail invoiceDetail) {
		invoiceDetailRepository.save(invoiceDetail);
	}

}
