package com.wipro.storeManagement.model;

public class ProductPrice {

	private int productId;
	private double base_price;
	private double current_price;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getBase_price() {
		return base_price;
	}

	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}
}
