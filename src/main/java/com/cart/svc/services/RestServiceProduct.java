package com.cart.svc.services;

import com.cart.svc.model.dao.AccountDao;
import com.cart.svc.model.dao.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceProduct {
    private String productAPI = "http://localhost:8181/product-svc/product";

    public ProductDao getProductById(Integer id) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ProductDao product = restTemplate.getForObject(productAPI+"/getproductbyid?id="+id, ProductDao.class);
            return product;
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
