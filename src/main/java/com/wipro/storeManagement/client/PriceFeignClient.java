package com.wipro.storeManagement.client;


import com.wipro.storeManagement.fallback.DefaultFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.storeManagement.model.ProductPrice;




@FeignClient(name="price-service", url="http://localhost:8030" ,fallbackFactory = DefaultFallback.class)
public interface PriceFeignClient {



	@GetMapping("/productPrice/{id}")
	public ProductPrice getPrice(@PathVariable(value="id") int id);

}



