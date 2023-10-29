package com.products.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	public Invoice() {
		
	}
	
	public Invoice(String customername,String customerphone, String referenceid, float totalquantity, float discountpercent, float discountamount, float totalamount, float payableamount) {
		this.customername = customername;
		this.customerphone = customerphone;
		this.referenceid = referenceid;
		this.totalquantity = totalquantity;
		this.discountpercent = discountpercent;
		this.discountamount = discountamount;
		this.totalamount = totalamount;
		this.payableamount = payableamount;
	}

	public Invoice(int id, String customername,String customerphone, String referenceid, float totalquantity, float discountpercent, float discountamount, float totalamount, float payableamount) {
		super();
		this.id = id;
		this.customername = customername;
		this.customerphone = customerphone;
		this.referenceid = referenceid;
		this.totalquantity = totalquantity;
		this.discountpercent = discountpercent;
		this.discountamount = discountamount;
		this.totalamount = totalamount;
		this.payableamount = payableamount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_name")
	private String customername;
	
	@Column(name  = "customer_phone")
	private String customerphone;
	
	@Column(name = "reference_id")
	private String referenceid;
	
	@Column(name = "total_quantity")
	private float totalquantity;
	
	@Column(name = "discount_percent")
	private float discountpercent;
	
	@Column(name = "discount_amount")
	private float discountamount;
	
	@Column(name  = "total_amount")
	private float totalamount;
	
	@Column(name = "payable_amount")
	private float payableamount;

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customername;
	}

	public void setName(String customername) {
		this.customername = customername;
	}
	
	public String getCustomerPhone() {
		return customerphone;
	}

	public void setCustomerPhone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getReferenceID() {
		return referenceid;
	}

	public void setReferenceID(String referenceid) {
		this.referenceid = referenceid;
	}
	
	public float getTotalQuantity() {
		return totalquantity;
	}

	public void setTotalQuantity(float totalquantity) {
		this.totalquantity = totalquantity;
	}
	
	public float getDiscountPercent() {
		return discountpercent;
	}

	public void setDiscountPercent(float discountpercent) {
		this.discountpercent = discountpercent;
	}
	
	public float getDiscountAmount() {
		return discountamount;
	}

	public void setDiscountAmount(float discountamount) {
		this.discountamount = discountamount;
	}
	
	public float getTotalAmount() {
		return totalamount;
	}

	public void setTotalAmount(float totalamount) {
		this.totalamount = totalamount;
	}
	
	public float getPayableAmount() {
		return payableamount;
	}

	public void setPayableAmount(float payableamount) {
		this.payableamount = payableamount;
	}

	public String toString() {
		return id + "  " + customername + "  " + customerphone + " " + referenceid + "  " + totalquantity + "  " + discountpercent + "  " + discountamount+ "  "+totalamount+"  "+payableamount;
	}

}
