package com.macwebapps.core.user.entity;

/**
 * Created by froilan.macugay@pictureworks.com.au on 26/4/17.
 */
public enum Role {

    ADMIN, PREMIUM_MEMBER, MEMBER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
