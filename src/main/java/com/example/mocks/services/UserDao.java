package com.example.mocks.services;

import com.example.mocks.model.User;

import java.util.ArrayList;
import java.util.List;
public interface UserDao {

    public void addUsers();

    User getUserByName(String name);

    List<User> findAllUsers();
}
