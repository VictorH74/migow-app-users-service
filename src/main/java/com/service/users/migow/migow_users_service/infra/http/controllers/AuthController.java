package com.service.users.migow.migow_users_service.infra.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.dtos.auth.JwtResponseDTO;
import com.service.users.migow.migow_users_service.application.dtos.auth.UserCredentialsDTO;
import com.service.users.migow.migow_users_service.application.services.JwtService;
import com.service.users.migow.migow_users_service.domain.entities.User;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody UserCredentialsDTO credentials) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.getLogin(), credentials.getPassword()));

            User user = (User) authentication.getPrincipal();

            if (authentication.isAuthenticated())
                return JwtResponseDTO.builder().accessToken(jwtService.GenerateToken(user.getId())).build();

            throw new UsernameNotFoundException("invalid user request..!!");

        } catch (UsernameNotFoundException e) {
            throw e;
        } catch (AuthenticationException e) {
            log.error(e);
            throw new UsernameNotFoundException(e.getMessage());
        }

    }
}
