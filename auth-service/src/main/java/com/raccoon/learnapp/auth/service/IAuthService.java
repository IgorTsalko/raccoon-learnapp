package com.raccoon.learnapp.auth.service;

import com.raccoon.learnapp.auth.model.Credentials;
import com.raccoon.learnapp.auth.model.TokenDTO;

public interface IAuthService {

    TokenDTO loginUser(Credentials credentials);
}
