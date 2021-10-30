package com.su.hydrangea.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "카카오 로그인 request", description = "카카오 로그인 request")
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "카카오 토큰", example = "kakaoToken")
        private String kakaoToken;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "카카오 로그인 response", description = "카카오 로그인 response")
    public static class Response {

        @ApiModelProperty(value = "access 토큰", example = "accessToken")
        private String accessToken;

        @ApiModelProperty(value = "refresh 토큰", example = "refreshToken")
        private String refreshToken;

    }

}
