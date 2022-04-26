package com.raccoon.learnapp.auth.handler;

import com.raccoon.learnapp.auth.model.Token;

public interface TokenProvider {

    Token generateToken();
}
