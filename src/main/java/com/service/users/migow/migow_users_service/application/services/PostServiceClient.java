package com.service.users.migow.migow_users_service.application.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.service.users.migow.migow_users_service.application.dtos.users.CreateUserDTO;

@FeignClient(name = "post-service", url = "http://localhost:8082/api/v1/")
public interface PostServiceClient {

    @PostMapping("users/")
    void createUser(@RequestBody CreateUserDTO user);
}
