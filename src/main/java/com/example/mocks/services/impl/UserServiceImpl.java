package com.example.mocks.services.impl;

import com.example.mocks.model.User;
import com.example.mocks.services.UserDao;
import com.example.mocks.services.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        User foundUser = userDao.getUserByName(user.getName());
        return foundUser != null;
    }
}
