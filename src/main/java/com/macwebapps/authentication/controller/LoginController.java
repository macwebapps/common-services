package com.macwebapps.authentication.controller;

import com.macwebapps.authentication.dto.LoginRequest;
import com.macwebapps.authentication.model.AccessJwtToken;
import com.macwebapps.authentication.model.UserContext;
import com.macwebapps.user.entity.User;
import com.macwebapps.user.service.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by froilan.macugay@pictureworks.com.au on 7/4/17.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequest req){

        User user = service.getUserByName(req.getUsername());

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //TODO encrypt password

        if(!req.getPassword().equals(user.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);


        Claims claims = Jwts.claims().setSubject(userContext.getUsername());
        claims.put("scopes", userContext.getAuthorities().stream().map(s -> s.toString()).collect(Collectors.toList()));

        LocalDateTime currentTime = LocalDateTime.now();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(60)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, "xm8EV6Hy5RMFK4EEACIDAwQus") //TODO put key in properties file
                .compact();

        return new ResponseEntity<>(new AccessJwtToken(token, claims), HttpStatus.OK);

    }
}
