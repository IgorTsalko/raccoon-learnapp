package com.raccoon.learnapp.user.service;

import com.raccoon.learnapp.user.model.UserRegistrationData;
import com.raccoon.learnapp.user.model.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    void saveUser(UserRegistrationData data);

    UserDTO getUser(Long id);
}
