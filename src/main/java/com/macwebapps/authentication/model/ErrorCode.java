package com.macwebapps.authentication.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by froilan.macugay@pictureworks.com.au on 27/4/17.
 */
public enum ErrorCode {
    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);

    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
