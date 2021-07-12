package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{
	
	Invoice findByInvoiceID(int invoiceID);
	
}
