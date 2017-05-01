package com.macwebapps.authentication.model;

/**
 * Created by froilan.macugay@pictureworks.com.au on 27/4/17.
 */
public enum Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
