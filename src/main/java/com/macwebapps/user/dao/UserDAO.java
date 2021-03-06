package com.macwebapps.user.dao;

import com.macwebapps.user.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by froilan.macugay@pictureworks.com.au on 8/4/17.
 */
@Transactional
@Repository
public class UserDAO implements IUserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUserByName(String username) {
        Query q = entityManager.createQuery("FROM User WHERE user_name = :username", User.class);
        q.setParameter("username", username);

        List<User> users = q.getResultList();
        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User newUser = getUserByName(user.getUsername());
        if(StringUtils.isNotBlank(user.getUsername())){
            newUser.setUsername(user.getUsername());
        }
        if(StringUtils.isNotBlank(user.getPassword())){
            newUser.setPassword(user.getPassword());
        }
        entityManager.flush();
    }

    @Override
    public void deleteUser(String username) {
        entityManager.remove(getUserByName(username));
    }

}
