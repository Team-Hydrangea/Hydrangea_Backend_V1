package com.su.hydrangea.global.security;

import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.repository.UserRepository;
import com.su.hydrangea.global.security.details.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<User> user= userRepository.findById(Long.parseLong(id));

        if(user.isPresent()) {
            return new AuthUserDetails(user.get());
        }
        throw new UsernameNotFoundException(id);
    }

}
