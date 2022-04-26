package com.raccoon.learnapp.user.model;

import lombok.Data;

@Data
public class UserRegistrationData {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
}
