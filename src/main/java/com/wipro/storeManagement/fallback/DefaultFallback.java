package com.wipro.storeManagement.fallback;

import com.wipro.storeManagement.client.PriceFeignClient;
import com.wipro.storeManagement.model.ProductPrice;
import org.springframework.web.bind.annotation.PathVariable;

public class DefaultFallback implements PriceFeignClient {

    @Override
    public ProductPrice getPrice(@PathVariable(value="id") int id){
       return null;
    }

}