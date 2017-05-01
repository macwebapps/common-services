package com.macwebapps.user.controller;

import com.macwebapps.authentication.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by froilan.macugay@pictureworks.com.au on 1/5/17.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<LoginResponse> getUsers(){
        LoginResponse response = new LoginResponse("123");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
