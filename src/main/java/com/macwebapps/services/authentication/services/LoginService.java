package com.macwebapps.services.authentication.services;

import com.macwebapps.services.authentication.dao.LoginDAO;
import com.macwebapps.services.authentication.dto.Account;

/**
 * Created by froilan.macugay@pictureworks.com.au on 8/4/17.
 */
public class LoginService {

    // FIXME inject
    private LoginDAO dao = new LoginDAO();


    public Account login(String id){

        Account account = dao.getUser(id);
        if(account == null){
            return new Account("");
        }

        return account;
    }
}
