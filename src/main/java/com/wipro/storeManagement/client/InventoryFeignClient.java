package com.wipro.storeManagement.client;


import com.wipro.storeManagement.fallback.DefaultFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="inventory-service",url= "http://localhost:8060", fallbackFactory = DefaultFallback.class)
public interface InventoryFeignClient {



	@GetMapping("/inventory/getstock/{inventory_cd}")
	public long getVolume(@PathVariable(value = "inventory_cd") int id);

}



