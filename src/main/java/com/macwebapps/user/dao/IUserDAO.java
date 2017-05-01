package com.macwebapps.user.dao;

import com.macwebapps.user.entity.User;

import java.util.List;

/**
 * Created by froilan.macugay@pictureworks.com.au on 21/4/17.
 */
public interface IUserDAO {

    List<User> getAllUsers();
    User getUserByName(String username);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String username);

}
