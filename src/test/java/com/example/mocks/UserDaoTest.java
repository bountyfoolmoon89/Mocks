package com.example.mocks;

import com.example.mocks.model.User;
import com.example.mocks.services.UserDao;
import com.example.mocks.services.impl.UserDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    public void testGetUserByNameIfUserExist() {
        UserDao userDao = new UserDaoImpl();
        String existingUserName = "Даниил";

        User foundUser = userDao.getUserByName(existingUserName);

        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(existingUserName, foundUser.getName());
    }

    @Test
    public void testGetUserByNameIfUserNonExist() {
        UserDao userDao = new UserDaoImpl();
        String nonExistingUserName = "Игорь";

        User foundUser = userDao.getUserByName(nonExistingUserName);

        Assertions.assertNull(foundUser);
    }
}
