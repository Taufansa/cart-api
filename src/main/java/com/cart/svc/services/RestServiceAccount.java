package com.cart.svc.services;

import com.cart.svc.model.dao.AccountDao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class RestServiceAccount {

    private String accountAPI = "http://localhost:8383/account-svc/account";

    public AccountDao getAccountbyId(String id) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            AccountDao account = restTemplate.getForObject(accountAPI+"/getbyid?id="+id, AccountDao.class);
            return account;
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

}
