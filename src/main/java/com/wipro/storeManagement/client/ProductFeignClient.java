package com.wipro.storeManagement.client;


import com.wipro.storeManagement.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@FeignClient(name="product-service" , url="http://localhost:8070")
public interface ProductFeignClient {

	@GetMapping(value = "/products/{id}")
	public Product getProduct(@PathVariable(value="id") Long id);
	@PostMapping(value = "/products/add")
	public Product addProduct(@RequestBody Product acct);
	@PutMapping(value = "/products/delete")
	public Product deleteProduct(@RequestBody Product acct);
	}
//
//	@GetMapping("/customers/getall")
//	public List<Customer> getAllCustomers();
//
//	@GetMapping("/customers/{id}")
//	public Customer getCustomer(@PathVariable(value="id") Long id);
//
//	@PostMapping("/customers/add")
//	public Customer saveCustomer(@RequestBody Customer acct);
//
//	@PutMapping("/customers/delete")
//	public Customer deleteCustomer(@RequestBody Customer acct);
//
//	@PutMapping("/customers/update")
//	public Customer updateCustomer(@RequestBody Customer acct);
//
//
//	// Customers x Products methods
//
//	@GetMapping("/customers/products/{id}")
//	public List<Customer> getCustomersByProductId(@PathVariable(value="id") Long id);
//
//	@PostMapping("/customers/{id}/products/addnew")
//	public Customer associateProduct(@PathVariable(value="id") Long id, @RequestBody Product prod);
//
//	@PostMapping("/customers/{id_cu}/products/addexisting")
//	public Customer associateProductById(@PathVariable(value="id_cu") Long id_cu, @RequestBody Long id_pr);
//
//	@DeleteMapping("/customers/{id_cu}/products/delete")
//	public Customer deleteCustomerProduct(@PathVariable(value="id_cu") Long id_cu, @RequestBody Long id_pr);
