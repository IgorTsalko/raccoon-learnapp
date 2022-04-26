package com.raccoon.learnapp.auth.service;

import com.raccoon.learnapp.auth.model.Credentials;
import com.raccoon.learnapp.auth.model.Token;

public interface IAuthService {

    Token loginUser(Credentials credentials);
}
