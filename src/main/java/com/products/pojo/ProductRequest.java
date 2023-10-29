package com.products.pojo;

public class ProductRequest {
	
		String name;
		float quantity;
		float amount;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public float getQuantity() {
			return quantity;
		}

		public void setQuantity(float quantity) {
			this.quantity = quantity;
		}
		
		public float getAmount() {
			return amount;
		}

		public void setAmount(float amount) {
			this.amount = amount;
		}

		public String toString() {
			return name + "  " + quantity+ "  "+amount;
		}

}
