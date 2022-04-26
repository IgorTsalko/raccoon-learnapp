package com.raccoon.learnapp.auth.service;

import com.raccoon.learnapp.auth.handler.TokenProvider;
import com.raccoon.learnapp.auth.model.Credentials;
import com.raccoon.learnapp.auth.model.Token;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService implements IAuthService {

    private final TokenProvider tokenProvider;

    @Override
    public Token loginUser(Credentials credentials) {
        // todo: get user with user-service
        // todo: credential checks with BCrypt.checkpw()

        return tokenProvider.generateToken();
    }
}
