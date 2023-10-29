package com.products.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {
	
	public Billing() {
		
	}

	public Billing(String referenceid, String pname, float quantity, float price, float amount) {
		super();
		this.referenceid = referenceid;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
	
	public Billing(int id, String referenceid, String pname, float quantity, float price, float amount) {
		super();
		this.id = id;
		this.referenceid = referenceid;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "reference_id")
	private String referenceid;

	@Column(name = "product_name")
	private String pname;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "amount")
	private float amount;

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getReferenceId() {
		return referenceid;
	}

	public void setRefereceId(String referenceid) {
		this.referenceid = referenceid;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String toString() {
		return id + "  " + referenceid + "  " + pname + "  " + quantity + "  " + price + "  " + amount;
	}

}
