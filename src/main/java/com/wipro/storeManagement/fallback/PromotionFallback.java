package com.wipro.storeManagement.fallback;

import com.wipro.storeManagement.client.PromotionFeignClient;
import com.wipro.storeManagement.model.CustomerPromotion;
import com.wipro.storeManagement.model.ProductPromotion;

public class PromotionFallback implements PromotionFeignClient {


        @Override
        public CustomerPromotion getPromotionByCustomerId(int id) {
                return new CustomerPromotion();
        }

        @Override
        public void addPromotionToCustomer(CustomerPromotion Customer) {

        }

        @Override
        public ProductPromotion getPromotionByProductId(Long id) {
                return new ProductPromotion();
        }

        @Override
        public void addPromotionToProduct(ProductPromotion produstPromotion) {

        }

}