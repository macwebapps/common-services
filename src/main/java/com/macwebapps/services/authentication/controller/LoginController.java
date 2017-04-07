package com.macwebapps.services.authentication.controller;

import com.macwebapps.services.authentication.dto.Account;
import com.macwebapps.services.authentication.dto.LoginDTO;
import com.macwebapps.services.authentication.services.LoginService;
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

    // FIXME inject instead of instantiation
    private LoginService service = new LoginService();

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> login(@PathVariable String id, LoginDTO dto){

        Account account = service.login(id);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
