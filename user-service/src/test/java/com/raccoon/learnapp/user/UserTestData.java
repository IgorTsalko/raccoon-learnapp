package com.raccoon.learnapp.user;

import com.raccoon.learnapp.user.dao.entity.UserEntity;
import com.raccoon.learnapp.user.model.UserRegistrationData;

public class UserTestData {

    public static final Long ID = 1L;
    public static final String FIRST_NAME = "Name";
    public static final String LAST_NAME = "Surname";
    public static final String LOGIN = "Login";
    public static final String EMAIL = "email@gmail.com";
    public static final String PASSWORD = "password12345";
    public static final Integer LEVEL = 5;

    public static UserEntity generateUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setId(ID);
        entity.setFirstName(FIRST_NAME);
        entity.setLastName(LAST_NAME);
        entity.setLogin(LOGIN);
        entity.setEmail(EMAIL);
        entity.setLevel(LEVEL);
        return entity;
    }

    public static UserRegistrationData generateUserRegistrationData() {
        UserRegistrationData userRegistrationData = new UserRegistrationData();
        userRegistrationData.setFirstName(FIRST_NAME);
        userRegistrationData.setLastName(LAST_NAME);
        userRegistrationData.setLogin(LOGIN);
        userRegistrationData.setEmail(EMAIL);
        userRegistrationData.setPassword(PASSWORD);
        return userRegistrationData;
    }
}
