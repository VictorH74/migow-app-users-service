package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.auth.CustomUserDetails;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        log.debug("Entering in loadUserByUsername Method...");

        User user = jpaUserRepository.findUserByLogin(login).orElseThrow(() -> {
            log.error("Username/Email not found: " + login);
            return new UsernameNotFoundException("Username/Email not found: " + login);
        });

        log.info("User Authenticated Successfully..!!!");
        log.info(user.toString());
        return new CustomUserDetails(user);
    }
}
