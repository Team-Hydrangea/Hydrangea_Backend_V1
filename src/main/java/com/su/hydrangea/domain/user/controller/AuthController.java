package com.su.hydrangea.domain.user.controller;

import com.su.hydrangea.domain.user.dto.LoginDto;
import com.su.hydrangea.domain.user.dto.TokenRefreshDto;
import com.su.hydrangea.domain.user.service.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ApiOperation(value = "카카오 oauth 로그인", notes = "카카오 oauth 토큰을 받아서 로그인합니다")
    public LoginDto.Response login(@Valid @RequestBody LoginDto.Request request) {
        return authService.login(request);
    }

    @PostMapping("/token-refresh")
    @ApiOperation(value = "토큰 리프레쉬", notes = "리프레쉬 토큰을 받아서 액세스 토큰을 반환합니다")
    public TokenRefreshDto.Response tokenRefresh(@Valid @RequestBody TokenRefreshDto.Request request) {
        return authService.tokenRefresh(request);
    }

}
