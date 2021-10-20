package com.su.hydrangea.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String message;
    private final int status;

    public ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus();
    }

    public ErrorResponse(int status, String message) {
        this.message = message;
        this.status = status;
    }

}
