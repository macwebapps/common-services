package com.macwebapps.authentication.exception;

import com.macwebapps.authentication.model.JwtToken;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by froilan.macugay@pictureworks.com.au on 27/4/17.
 */
public class JwtExpiredTokenException extends AuthenticationException {

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
