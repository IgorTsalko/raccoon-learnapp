package com.raccoon.learnapp.auth.controller;

import com.raccoon.learnapp.auth.model.Credentials;
import com.raccoon.learnapp.auth.model.TokenDTO;
import com.raccoon.learnapp.auth.service.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/issue-token")
    public TokenDTO loginUser(@RequestBody Credentials credentials) {
        return authService.loginUser(credentials);
    }
}
