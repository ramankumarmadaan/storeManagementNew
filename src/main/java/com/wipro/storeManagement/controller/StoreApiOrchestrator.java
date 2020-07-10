package com.wipro.storeManagement.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.wipro.storeManagement.Constant;
import com.wipro.storeManagement.client.InventoryFeignClient;
import com.wipro.storeManagement.client.ProductFeignClient;
import com.wipro.storeManagement.model.*;
import com.wipro.storeManagement.client.PriceFeignClient;
import com.wipro.storeManagement.client.PromotionFeignClient;
import com.wipro.storeManagement.service.CustomerFeignClient;
import com.wipro.storeManagement.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;


@RestController
public class StoreApiOrchestrator {

	@Autowired
	PromotionFeignClient promotionFeignClient;

	@Autowired
	ProductFeignClient productFeignClient;

	@Autowired
	StoreService storeService;

	@RequestMapping("/productDetails/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ProductDetails productDetails(@PathVariable long id) {

		ProductDetails productDetails = storeService.getProductDetails(id);
		ProductPrice productPrice = storeService.getPrice((int) id);
		productDetails.setVolume(storeService.getVolume((int) id));
		productDetails.setPrice(storeService.getDiscountedPrice(id, productPrice));
		return productDetails;

	}

	@PostMapping("/product")
	@ResponseStatus(value = HttpStatus.OK)
	public Product addNewProduct(@RequestBody Product product) {
		return storeService.addNewProduct(product);
	}



	@PostMapping("/customer")
	@ResponseStatus(value = HttpStatus.OK)
	public void addNewCustomer(@RequestBody Customer customer) {
		storeService.addNewCustomer(customer);
	}

}
/*
 * 1. Call getProductDetails--> call getProduct/{id} and getproductPrice and
 * return productDetails with price
 * 2. Call Create Product --> call createProduct and call savePrice

 */





/*
 * class ProductDetails{ int productId; String productName; String
 * productCategory; double currentPrice;
 *
 * public ProductDetails() { super(); // TODO Auto-generated constructor stub }
 *
 * public int getProductId() { return productId; }
 *
 * public void setProductId(int productId) { this.productId = productId; }
 *
 * public String getProductName() { return productName; }
 *
 * public void setProductName(String productName) { this.productName =
 * productName; }
 *
 * public String getProductCategory() { return productCategory; }
 *
 * public void setProductCategory(String productCategory) { this.productCategory
 * = productCategory; }
 *
 * public double getCurrentPrice() { return currentPrice; }
 *
 * public void setCurrentPrice(double currentPrice) { this.currentPrice =
 * currentPrice; }
 *
 * @Override public String toString() { return "ProductDetails [productId=" +
 * productId + ", productName=" + productName + ", productCategory=" +
 * productCategory + ", currentPrice=" + currentPrice + "]"; } }
 */
	