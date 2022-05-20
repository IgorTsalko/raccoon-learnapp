package com.raccoon.learnapp.auth.model;

import lombok.Data;

@Data
public class TokenDTO {
    private final String accessToken;
    private final String refreshToken;
}
