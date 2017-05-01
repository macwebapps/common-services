package com.macwebapps.user.service;

import com.macwebapps.user.dao.IUserDAO;
import com.macwebapps.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by froilan.macugay@pictureworks.com.au on 8/4/17.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO dao;

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User getUserByName(String username) {
        return dao.getUserByName(username);
    }

    @Override
    public synchronized boolean addUser(User user) {

        if(dao.getUserByName(user.getUsername()) !=null ){
            return false;
        } else {
            dao.addUser(user);
            return true;
        }
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(String username) {
        dao.deleteUser(username);
    }
}
