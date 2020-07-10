package com.wipro.storeManagement.service;

import java.util.List;

import com.wipro.storeManagement.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@FeignClient(name="customer-service" , url= "http://localhost:8060")
public interface CustomerFeignClient {

	@GetMapping("/customers/getall")
	public List<Customer> getAllCustomers();

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable(value="id") Long id);

	@PostMapping("/customers/add")
	public Customer saveCustomer(@RequestBody Customer acct);

	@PutMapping("/customers/delete")
	public Customer deleteCustomer(@RequestBody Customer acct);

	@PutMapping("/customers/update")
	public Customer updateCustomer(@RequestBody Customer acct);


}