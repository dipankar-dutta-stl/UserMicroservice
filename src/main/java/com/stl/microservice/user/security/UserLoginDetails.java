package com.stl.microservice.user.security;

import com.stl.microservice.user.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserLoginDetails implements UserDetails {

    User USER;

    public UserLoginDetails(User USER) {
        this.USER = USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return USER.getPASSWORD();
    }

    @Override
    public String getUsername() {
        return USER.getUNIQUE_ID();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
