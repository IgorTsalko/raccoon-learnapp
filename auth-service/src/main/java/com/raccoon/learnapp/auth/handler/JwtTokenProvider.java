package com.raccoon.learnapp.auth.handler;

import com.raccoon.learnapp.auth.model.Token;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider implements TokenProvider {

    @Override
    public Token generateToken() {
        // todo: issue new JWT-token
        return new Token("Mock token: " + "jwt-token-123");
    }
}
