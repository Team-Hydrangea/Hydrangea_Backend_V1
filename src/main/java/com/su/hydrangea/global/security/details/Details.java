package com.su.hydrangea.global.security.details;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface Details {

    public Collection<? extends GrantedAuthority> getAuthorities();

}
