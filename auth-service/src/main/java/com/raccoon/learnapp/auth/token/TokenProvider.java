package com.raccoon.learnapp.auth.token;

import com.raccoon.learnapp.auth.model.TokenDTO;
import org.springframework.security.core.Authentication;

public interface TokenProvider {

    TokenDTO generateToken(Authentication authentication);
}
