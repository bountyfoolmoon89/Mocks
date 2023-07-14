package com.example.mocks.services.impl;

import com.example.mocks.model.User;
import com.example.mocks.services.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public List<User> userList = new ArrayList<>();

    public UserDaoImpl() {
        addUsers();
    }

    public void addUsers() {
        userList.add(new User("Даниил"));
        userList.add(new User("Роман"));
        userList.add(new User("Юлия"));
    }

    @Override
    public User getUserByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userList;
    }
}
