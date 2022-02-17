package com.cart.svc.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartDao {
    private String accountid;
    private String cartid;
    private Integer productid;
    private Integer qty;
}
