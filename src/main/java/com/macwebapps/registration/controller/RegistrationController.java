package com.macwebapps.registration.controller;

import com.macwebapps.user.entity.User;
import com.macwebapps.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Resource;

/**
 * Created by froilan.macugay@pictureworks.com.au on 21/4/17.
 */
@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    private IUserService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Resource<User> userResource){

        User user = userResource.getContent();
        boolean isCreated = service.addUser(user);

        if(!isCreated){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
