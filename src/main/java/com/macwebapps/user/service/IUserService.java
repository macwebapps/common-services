package com.macwebapps.user.service;

import com.macwebapps.user.entity.User;

import java.util.List;

/**
 * Created by froilan.macugay@pictureworks.com.au on 21/4/17.
 */
public interface IUserService {

    List<User> getAllUsers();
    User getUserByName(String username);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(String username);
}
