package com.service.users.migow.migow_users_service.application.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.users.migow.migow_users_service.application.dtos.users.CreateUserDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceClient {

    private final RestTemplate restTemplate;
    private final String postServiceUrl = "http://localhost:8080/p-s/users"; 

    public void createUserInPostService(CreateUserDTO user) {
        restTemplate.postForEntity(postServiceUrl, user, Void.class);
    }
}

