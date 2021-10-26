package com.su.hydrangea.domain.user.util.api.client;

import com.su.hydrangea.domain.user.util.api.dto.KakaoUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "kakaoClient", url = "https://kapi.kakao.com/v2/user")
public interface KakaoClient {

    @GetMapping("/me")
    KakaoUserInfo.Response getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

}
