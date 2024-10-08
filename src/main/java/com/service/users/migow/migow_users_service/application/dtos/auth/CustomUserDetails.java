package com.service.users.migow.migow_users_service.application.dtos.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.service.users.migow.migow_users_service.domain.entities.User;

import lombok.Getter;

@Getter
public class CustomUserDetails extends User implements UserDetails {

    private final UUID id;
    private final String username;
    private final String password;
    private final Set<String> roles;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(User byUsername) {
        this.id = byUsername.getId();
        this.username = byUsername.getUsername();
        this.password = byUsername.getPassword();
        this.roles = byUsername.getRoles();
        List<GrantedAuthority> auths = new ArrayList<>();

        for (String role : byUsername.getRoles()) {

            auths.add(new SimpleGrantedAuthority(role));
        }
        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
