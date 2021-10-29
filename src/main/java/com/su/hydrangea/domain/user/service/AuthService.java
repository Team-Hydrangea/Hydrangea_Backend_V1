package com.su.hydrangea.domain.user.service;

import com.su.hydrangea.domain.user.dto.LoginDto;
import com.su.hydrangea.domain.user.dto.TokenRefreshDto;
import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.repository.UserRepository;
import com.su.hydrangea.domain.user.util.api.client.KakaoClient;
import com.su.hydrangea.domain.user.util.api.dto.KakaoUserInfo;
import com.su.hydrangea.global.error.exception.InvalidTokenException;
import com.su.hydrangea.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final KakaoClient kakaoClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginDto.Response login(LoginDto.Request request) {
        KakaoUserInfo.Response userInfo = kakaoClient.getUserInfo(request.getKakaoToken());

        User user = User.builder()
                .id(userInfo.getId())
                .build();
        userRepository.save(user);

        String id = String.valueOf(user.getId());
        String accessToken = jwtTokenProvider.generateAccessToken(id);
        String refreshToken = jwtTokenProvider.generateRefreshToken(id);

        return new LoginDto.Response(accessToken, refreshToken);
    }

    public TokenRefreshDto.Response tokenRefresh(TokenRefreshDto.Request request) {
        String refreshToken = request.getRefreshToken();

        if (jwtTokenProvider.validateRefreshToken(refreshToken)) {
            String id = jwtTokenProvider.getId(refreshToken);
            if (userRepository.existsById(Long.parseLong(id))) {
                String accessToken = jwtTokenProvider.generateAccessToken(id);
                return new TokenRefreshDto.Response(accessToken);
            }
        }
        throw new InvalidTokenException();
    }

}
