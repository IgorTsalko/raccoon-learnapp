package com.raccoon.learnapp.auth.model;

import lombok.Data;

import java.util.List;

@Data
public class AppUserDetails {
    private final Long id;
    private final String username;
    private final String password;
    private final List<String> roles;
    private final boolean active;
}
