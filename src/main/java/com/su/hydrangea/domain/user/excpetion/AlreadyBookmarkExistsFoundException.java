package com.su.hydrangea.domain.user.excpetion;

import com.su.hydrangea.global.error.ErrorCode;
import com.su.hydrangea.global.error.exception.GlobalException;

public class AlreadyBookmarkExistsFoundException extends GlobalException {

    public AlreadyBookmarkExistsFoundException() {
        super(ErrorCode.BOOKMARK_ALREADY_EXISTS);
    }

}
