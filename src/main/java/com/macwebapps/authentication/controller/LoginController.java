package com.macwebapps.authentication.controller;

import com.macwebapps.core.user.entity.User;
import com.macwebapps.core.user.service.IUserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by froilan.macugay@pictureworks.com.au on 7/4/17.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> login(@PathVariable String username, @RequestHeader(value="Authorization") String auth){

        User user = service.getUserByName(username);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String plainCreds = user.getUsername()+":"+user.getPassword();
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = "Basic " + new String(base64CredsBytes);

        if(!base64Creds.equals(auth)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
