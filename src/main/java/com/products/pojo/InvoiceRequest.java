package com.products.pojo;

import java.util.List;

public class InvoiceRequest  {

	private String customerName;
	private String customerPhone;
	private float discountPercent;
	
	private List<ProductRequest> products;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public float getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}
	public List<ProductRequest> getProducts() {
		return products;
	}
	public void setProducts(List<ProductRequest> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "InvoiceRequest [customerName=" + customerName + ", customerPhone=" + customerPhone
				+ ", discountPercent=" + discountPercent + ", products=" + products + "]";
	}
	
	

}
