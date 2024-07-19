package com.service.users.migow.migow_users_service.infra.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.dtos.JwtResponseDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.UserCredentialsDTO;
import com.service.users.migow.migow_users_service.application.services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody UserCredentialsDTO credentials) {
        // User retrievedUser = getUserByLoginUseCase.execute(credentials.getLogin());

        // TODO: check if credentials.password matchs with retrievedUser.password,
        // create json web token and return

        System.out.println(credentials.toString());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getLogin(), credentials.getPassword()));

        if (authentication.isAuthenticated())
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(credentials.getLogin())).build();

        throw new UsernameNotFoundException("invalid user request..!!");

    }
}
