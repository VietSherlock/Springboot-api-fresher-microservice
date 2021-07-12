package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Invoice;
import com.example.demo.repository.InvoiceRepository;

@Service
public class InvoiceServiceImp implements InvoiceService {

	private final InvoiceRepository invoiceRepository;

	@Autowired
	public InvoiceServiceImp(InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}

	/************** Read Invoice Methods ****************/

	// get all invoices
	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceRepository.findAll();
	}

	// get a invoice by invoiceID
	public Invoice findByInvoiceID(int invoiceID) {
		return invoiceRepository.findByInvoiceID(invoiceID);
	}
	
/*****************Save Invoice Methods*********************/
	
	//save a invoice
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	/********************Delete Invoice Methods**********************************/
	
	//delete invoice by invoiceID
	public void deleteById(int id) {
		invoiceRepository.deleteById(id);
	}
	
	
	/*********************Update Invoice Methods***********************************/
	
//	update a invoice
	public void updateInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

}
