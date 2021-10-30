package com.su.hydrangea.global.security;

import com.su.hydrangea.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {

    private final UserRepository userRepository;

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Long getId() {
        return Long.parseLong(getAuthentication().getName());
    }

    public boolean isLogin() {
        return getAuthentication() == null || !getAuthentication().getName().equals("anonymousUser");
    }

}
