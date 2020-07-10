package com.wipro.storeManagement.model;
import java.util.Set;


public class Customer {
	private Long id;
	private String name;
	private String email;
	private String category;
    private Set<Product> products;
    
    public Customer() {}        
    
    public Customer(Long id, String name, String email, String category) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.email = email;
    	this.category = category;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Set<Product> getProducts(){
	   	return products;
	} 
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email="+ email + ", category=" + category + "]";
	}

}
