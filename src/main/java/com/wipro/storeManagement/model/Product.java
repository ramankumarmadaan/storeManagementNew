package com.wipro.storeManagement.model;

import java.util.Set;

public class Product {
	private Long id;
	private String category;
	private String description;
    private Set<Customer> customers;
    
    public Product() {}
	
    public Product(Long id, String category, String description) {
    	super();
    	this.id = id;
    	this.category = category;
    	this.description = description;
    	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", description=" + description + "]";
	}
}
