package com.su.hydrangea.global.error.exception;

import lombok.Getter;

@Getter
public class FailToCurlException extends RuntimeException {

    private final int status;
    private final String message;

    public FailToCurlException(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
