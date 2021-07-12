package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.InvoiceDetail;

public interface InvoiceDetailService {
	
	List<InvoiceDetail> findAll();
	
	InvoiceDetail findByInvoiceDetailID(int invoiceDetailID);
	
	InvoiceDetail save(InvoiceDetail invoiceDetail);
	
	void deleteById(int id);
	
	void updateInvoiceDetail(InvoiceDetail invoiceDetail);
	
}
