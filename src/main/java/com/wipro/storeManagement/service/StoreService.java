package com.wipro.storeManagement.service;

import com.wipro.storeManagement.Constant;
import com.wipro.storeManagement.client.InventoryFeignClient;
import com.wipro.storeManagement.client.PriceFeignClient;
import com.wipro.storeManagement.client.ProductFeignClient;
import com.wipro.storeManagement.client.PromotionFeignClient;
import com.wipro.storeManagement.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StoreService {


    @Autowired
    PromotionFeignClient promotionFeignClient;

    @Autowired
    PriceFeignClient priceFeignClient;

    @Autowired
    ProductFeignClient productFeignClient;

    @Autowired
    com.wipro.storeManagement.service.CustomerFeignClient customerFeignClient;

    @Autowired
    InventoryFeignClient inventoryFeignClient;

    public double getDiscountedPrice(double currentPrice, int discount) {
        return (currentPrice * discount) / 100;
    }

    public ProductDetails getProductDetails(long id) {
        ModelMapper model = new ModelMapper();
        return model.map(productFeignClient.getProduct(id), ProductDetails.class);
    }

    public Product addNewProduct(@RequestBody Product product) {
        return productFeignClient.addProduct(product);
    }



    public int getVolume(@PathVariable int id) {
        return (int) inventoryFeignClient.getVolume(id);
    }

    public ProductPrice getPrice(@PathVariable int id) {
        return priceFeignClient.getPrice(id);
    }

    ////////////////////////////
    public int getCustomerId(@RequestBody Customer customer) {
        return (int) (long) customerFeignClient.saveCustomer(customer).getId();
    }

    public void addNewCustomer(@RequestBody Customer customer) {
        CustomerPromotion customerPromotion = new CustomerPromotion();
        customerPromotion.setCustomerId(getCustomerId(customer));
        customerPromotion.setPromotionCode(Constant.ADD_NEW_CUSTOMER_PROMOTION_CODE);
        addPromotionToNewCustomer(customerPromotion);
    }

    ///////////////////////////
    public void addPromotionToNewCustomer(CustomerPromotion customerPromotion) {
        promotionFeignClient.addPromotionToCustomer(customerPromotion);
    }

    public double getDiscountedPrice(@PathVariable long id, ProductPrice productPrice) {
        return getDiscountedPrice(productPrice.getCurrent_price(), promotionFeignClient.getPromotionByProductId(id).getDiscount());
    }
}
