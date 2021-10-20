package com.su.hydrangea.global.error.exception;

import com.su.hydrangea.global.error.ErrorCode;

public class InvalidTokenException extends GlobalException{

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}
