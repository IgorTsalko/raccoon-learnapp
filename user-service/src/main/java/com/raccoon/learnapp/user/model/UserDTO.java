package com.raccoon.learnapp.user.model;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private Integer level;
}
