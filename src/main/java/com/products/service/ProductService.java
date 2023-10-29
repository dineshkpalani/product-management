package com.products.service;

import java.util.List;

import com.products.pojo.Product;

public interface ProductService {
	
	public List<Product> getProductList();
	public List<Product> getFilterID();
	public List<Product> getProductListByCategory(String category);
	public Product getProductListByID(int id);
	public String add(Product platform);
	public String update(int id,Product platform);
	public String purchaseUpdate(int id,Product platform);
	public String delete(int id);
}
