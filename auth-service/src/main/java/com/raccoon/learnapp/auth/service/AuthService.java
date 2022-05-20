package com.raccoon.learnapp.auth.service;

import com.raccoon.learnapp.auth.token.TokenProvider;
import com.raccoon.learnapp.auth.model.Credentials;
import com.raccoon.learnapp.auth.model.TokenDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @Override
    public TokenDTO loginUser(Credentials credentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        return tokenProvider.generateToken(authentication);
    }
}
