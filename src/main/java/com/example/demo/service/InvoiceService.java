package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Invoice;

public interface InvoiceService {
	
	List<Invoice> findAll();
	
	Invoice findByInvoiceID(int invoiceID);
	
	Invoice save(Invoice invoice);
	
	void deleteById(int id);
	
	void updateInvoice(Invoice invoice);
	
}
