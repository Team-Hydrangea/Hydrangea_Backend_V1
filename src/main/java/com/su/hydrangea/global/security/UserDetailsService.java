package com.su.hydrangea.global.security;

import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.repository.UserRepository;
import com.su.hydrangea.global.security.details.Details;
import com.su.hydrangea.global.security.details.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsService {

    private final UserRepository userRepository;

    public Details loadById(String id) {
        Optional<User> user = userRepository.findById(Long.parseLong(id));
        if(user.isPresent()) {
            return new UserDetails(user.get());
        }

        return new Details() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

        };
    }
}
