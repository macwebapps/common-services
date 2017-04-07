package com.macwebapps.services.authentication.dao;

import com.macwebapps.services.authentication.dto.Account;

/**
 * Created by froilan.macugay@pictureworks.com.au on 8/4/17.
 */
public class LoginDAO {

    //TODO jpa implementation

    public Account getUser(String id){
        Account account = new Account(id);
        account.setFirstName("Michael");
        account.setLastName("Jordan");
        return account;
    }
}
