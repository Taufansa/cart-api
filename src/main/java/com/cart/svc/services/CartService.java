package com.cart.svc.services;

import com.cart.svc.model.dao.AccountDao;
import com.cart.svc.model.dao.ProductDao;
import com.cart.svc.model.dao.UpdateCartDao;
import com.cart.svc.model.entity.Cart;
import com.cart.svc.model.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestServiceAccount restServiceAccount;

    @Autowired
    private RestServiceProduct restServiceProduct;


    public Cart initCart(String accountid) throws Exception {
        try {
            AccountDao acc = restServiceAccount.getAccountbyId(accountid);
            Cart cart = cartRepository.findByAccount(acc);
            if (Objects.isNull(cart)){
                List<ProductDao> products = new ArrayList<ProductDao>();
                AccountDao account = restServiceAccount.getAccountbyId(accountid);
                Cart newCart = new Cart(
                        null,
                        0,
                        account,
                        products

                );
                return cartRepository.save(newCart);
            } else {
                return cart;
            }
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public String updateCart(UpdateCartDao updateCartDao) throws Exception {
        try {
            AccountDao account = restServiceAccount.getAccountbyId(updateCartDao.getAccountid());
            if (Objects.isNull(account)){
                return "Account Not Found";
            } else {
                ProductDao product = restServiceProduct.getProductById(updateCartDao.getProductid());
                if(Objects.isNull(product)){
                    return "Product Not Found";
                } else {
                    Cart cart = cartRepository.findByCartid(updateCartDao.getCartid());
                    if (Objects.nonNull(cart)){
                        List<ProductDao> products = cart.getProducts();
                        products.add(product);
                        cart.setProducts(products);
                        cart.setTotalprice(cart.getTotalprice() + (updateCartDao.getQty() * product.getPrice()));
                        cartRepository.save(cart);
                        return "Success to Add Product to Cart";
                    } else {
                        return "Please Init The Cart First";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Cart myCart(String cartid) throws Exception{
        try {
            return cartRepository.findByCartid(cartid);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }


}
