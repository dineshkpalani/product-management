package com.products.service;

import java.util.List;

import com.products.entity.Invoice;
import com.products.pojo.InvoiceRequest;
import com.products.entity.Product;

public interface InvoiceService {
	
	public List<Invoice> getInvoiceList();
//	public Product getProductListByID(int id);
	public String add(InvoiceRequest platform);
//	public String update(int id,Product platform);
//	public String purchaseUpdate(int id,Product platform);
//	public String delete(int id);
}
