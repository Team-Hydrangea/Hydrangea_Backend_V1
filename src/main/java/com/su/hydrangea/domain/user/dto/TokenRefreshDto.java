package com.su.hydrangea.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class TokenRefreshDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "토큰 리프레쉬 request", description = "토큰 리프레쉬 request")
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "refresh 토큰", example = "refreshToken")
        private String refreshToken;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "토큰 리프레쉬 response", description = "토큰 리프레쉬 response")
    public static class Response {

        @ApiModelProperty(value = "access 토큰", example = "accessToken")
        private String accessToken;

    }

}
