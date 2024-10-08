package com.service.users.migow.migow_users_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MigowUsersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigowUsersServiceApplication.class, args);
    }

}
