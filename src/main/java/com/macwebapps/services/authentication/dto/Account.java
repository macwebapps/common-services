package com.macwebapps.services.authentication.dto;

import java.util.Date;

/**
 * Created by froilan.macugay@pictureworks.com.au on 7/4/17.
 */
public class Account {

    private final String id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    //TODO make this as builder class


    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
