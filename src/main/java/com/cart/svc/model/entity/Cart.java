package com.cart.svc.model.entity;

import com.cart.svc.model.dao.AccountDao;
import com.cart.svc.model.dao.ProductDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
@Document(collection = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    @Id
    private String cartid;
    private Integer totalprice;
    private AccountDao account;
    private List<ProductDao> products;
}
