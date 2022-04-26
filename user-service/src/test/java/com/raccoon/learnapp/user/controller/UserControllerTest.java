package com.raccoon.learnapp.user.controller;

import com.raccoon.learnapp.user.UserTestData;
import com.raccoon.learnapp.user.model.UserRegistrationData;
import com.raccoon.learnapp.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRegistrationData userRegistrationData;

    @Test
    void getUsersTest() {
        userController.getUsers();
        verify(userService).getUsers();
    }

    @Test
    void saveUserTest() {
        ResponseEntity<Object> result = userController.saveUser(userRegistrationData);
        assertThat(result).isEqualTo(ResponseEntity.noContent().build());
        verify(userService).saveUser(userRegistrationData);
    }

    @Test
    void getUserByIdTest() {
        userController.getUser(UserTestData.ID);
        verify(userService).getUser(UserTestData.ID);
    }
}