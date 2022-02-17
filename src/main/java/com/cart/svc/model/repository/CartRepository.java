package com.cart.svc.model.repository;

import com.cart.svc.model.dao.AccountDao;
import com.cart.svc.model.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByAccount(AccountDao account);
    Cart findByCartid(String cartid);
}
