package com.example.mocks;

import com.example.mocks.model.User;
import com.example.mocks.services.UserDao;
import com.example.mocks.services.UserService;
import com.example.mocks.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCheckUserExistIfUserExist() {
        String existingUserName = "Юлия";
        User existingUser = new User(existingUserName);

        when(userDaoMock.getUserByName(existingUserName)).thenReturn(existingUser);

        boolean userExists = userServiceImpl.checkUserExist(existingUser);

        Assertions.assertTrue(userExists);
    }

    @Test
    public void testCheckUserExistIfUserNonExist() {
        String nonExistingUserName = "Василий";
        User nonExistingUser = new User(nonExistingUserName);

        when(userDaoMock.getUserByName(nonExistingUserName)).thenReturn(null);

        boolean userExists = userServiceImpl.checkUserExist(nonExistingUser);

        Assertions.assertFalse(userExists);
    }
}
