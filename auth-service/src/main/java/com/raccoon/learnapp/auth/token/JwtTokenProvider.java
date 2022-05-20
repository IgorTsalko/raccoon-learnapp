package com.raccoon.learnapp.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.raccoon.learnapp.auth.model.AppUserDetails;
import com.raccoon.learnapp.auth.model.TokenDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider implements TokenProvider {

    private static final String CLAIM_ID_NAME = "id";
    private static final String CLAIM_ROLES_NAME = "roles";

    @Override
    public TokenDTO generateToken(Authentication authentication) {
        AppUserDetails userDetails = (AppUserDetails) authentication.getPrincipal();

        // todo: put secret to application.properties and retrieve via @ConfigurationProperties
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String accessToken = JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim(CLAIM_ID_NAME, userDetails.getId())
                .withClaim(CLAIM_ROLES_NAME, userDetails.getRoles())
                // todo: put number of milliseconds to application.properties and retrieve via @ConfigurationProperties
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 + 10 + 1000))
                // todo: put issuer name to application.properties and retrieve via @ConfigurationProperties
                .withIssuer("Raccoon Learn app")
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(userDetails.getUsername())
                // todo: put number of milliseconds to application.properties and retrieve via @ConfigurationProperties
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 + 30 + 1000))
                // todo: put issuer name to application.properties and retrieve via @ConfigurationProperties
                .withIssuer("Raccoon Learn app")
                .sign(algorithm);

        // should we put tokens into header?
        return new TokenDTO(accessToken, refreshToken);
    }
}
