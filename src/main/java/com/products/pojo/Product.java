package com.products.pojo;

public class Product {

	public Product() {
	}

	public Product(int id, String name,String description, String category, float stock, double buyingprice, double sellingprice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.stock = stock;
		this.buyingprice = buyingprice;
		this.sellingprice = sellingprice;
	}
	
		int id;
		public String name;
		String description;
		String category;
		float stock;
		double buyingprice;
		double sellingprice;

		public int getID() {
			return id;
		}

		public void setID(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		
		public float getStock() {
			return stock;
		}

		public void setStock(float stock) {
			this.stock = stock;
		}
		
		public double getBuyingPrice() {
			return buyingprice;
		}

		public void setBuyingPrice(double buyingprice) {
			this.buyingprice = buyingprice;
		}
		
		public double getSellingPrice() {
			return sellingprice;
		}

		public void setSellingPrice(double sellingprice) {
			this.sellingprice = sellingprice;
		}

		public String toString() {
			return id + "  " + name + "  " + description + " " + category + "  " + stock + "  " + buyingprice + "  " + sellingprice;
		}

}
