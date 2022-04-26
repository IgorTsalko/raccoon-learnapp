package com.raccoon.learnapp.user.controller;

import com.raccoon.learnapp.user.model.UserDTO;
import com.raccoon.learnapp.user.model.UserRegistrationData;
import com.raccoon.learnapp.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/registration")
    public ResponseEntity<Object> saveUser(@RequestBody UserRegistrationData data) {
        userService.saveUser(data);
        return ResponseEntity.noContent().build();
    }
}
