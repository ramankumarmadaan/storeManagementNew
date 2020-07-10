package com.wipro.storeManagement.client;

import com.wipro.storeManagement.model.CustomerPromotion;
import com.wipro.storeManagement.model.ProductPromotion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.wipro.storeManagement.fallback.PromotionFallback;
@FeignClient(name = "promotion-service",url= "http://localhost:8080", fallbackFactory = PromotionFallback.class)
public interface PromotionFeignClient {


    @GetMapping("/promotion/customer/{customerId}")
    CustomerPromotion getPromotionByCustomerId(@PathVariable(value="customerId") int id);

    @PostMapping("/promotion/customer/updateCustomer")
    void addPromotionToCustomer(@RequestBody CustomerPromotion Customer);

    @GetMapping("/promotion/product/{productId}")
    ProductPromotion getPromotionByProductId(@PathVariable(value = "productId") Long id);

    @PostMapping("/promotion/product/updateProduct")
    void addPromotionToProduct(@RequestBody ProductPromotion produstPromotion);

}
