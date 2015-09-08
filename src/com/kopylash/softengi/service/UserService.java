package com.kopylash.softengi.service;

import com.kopylash.softengi.dao.user.UserDao;
import com.kopylash.softengi.entity.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Владислав on 08.09.2015.
 */
@Named
public class UserService {
    @Inject
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public void createUser(User user) {

    }

    public void deleteUser(int userId) {
        userDao.delete(userId);
    }
}
