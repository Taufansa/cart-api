package com.cart.svc.api;

import com.cart.svc.model.dao.UpdateCartDao;
import com.cart.svc.model.entity.Cart;
import com.cart.svc.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-svc/cart/")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/initcart")
    public Cart initCart(@RequestParam("accountid") String accountid) throws Exception {
        return cartService.initCart(accountid);
    }

    @GetMapping("/mycart")
    public Cart myCart(@RequestParam("cartid") String cartid) throws Exception {
        return cartService.myCart(cartid);
    }

    @PatchMapping("/updatecart")
    public String updateCart(@RequestBody UpdateCartDao updateCartDao) throws Exception {
        return cartService.updateCart(updateCartDao);
    }
}
