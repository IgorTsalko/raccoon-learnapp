package com.raccoon.learnapp.user.exception;

import com.raccoon.learnapp.common.exception.ErrorMessageCode;
import com.raccoon.learnapp.common.exception.RaccoonException;

public class UserDoesNotExistException extends RaccoonException {

    public UserDoesNotExistException(Long id) {
        super(ErrorMessageCode.USER_DOES_NOT_EXIST_BY_ID, id);
    }
}
