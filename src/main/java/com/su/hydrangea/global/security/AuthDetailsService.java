package com.su.hydrangea.global.security;

import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.repository.UserRepository;
import com.su.hydrangea.global.security.details.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        try {
            User user = userRepository.findById(Long.parseLong(id)).get();
            return new AuthUserDetails(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException(id);
        }
    }

}
