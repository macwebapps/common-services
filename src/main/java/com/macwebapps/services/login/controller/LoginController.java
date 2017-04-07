package com.macwebapps.services.login.controller;

import com.macwebapps.services.login.dto.Account;
import com.macwebapps.services.login.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by froilan.macugay@pictureworks.com.au on 7/4/17.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> login(@PathVariable String id, LoginDTO dto){

        Account account = new Account(id);
        account.setFirstName("Michael");
        account.setLastName("Jordan");

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
