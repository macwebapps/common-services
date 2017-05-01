package com.macwebapps.authentication.dto;

/**
 * Created by froilan.macugay@pictureworks.com.au on 27/4/17.
 */
public class LoginResponse {

    private String token;

    public LoginResponse() {
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
