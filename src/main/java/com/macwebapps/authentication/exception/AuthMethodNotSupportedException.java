package com.macwebapps.authentication.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by froilan.macugay@pictureworks.com.au on 27/4/17.
 */

public class AuthMethodNotSupportedException extends AuthenticationServiceException {

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
