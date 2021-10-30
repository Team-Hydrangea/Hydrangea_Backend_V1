package com.su.hydrangea.domain.user.excpetion;

import com.su.hydrangea.global.error.ErrorCode;
import com.su.hydrangea.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
