package com.service.users.migow.migow_users_service.application.dtos.users;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserDTO {
    private UUID id;
    private final String password;
    private final String username;
    private final String name;
    private final String email;
    private final String profileImageUrl;
    private final String bgImageUrl;

    public void setId(UUID id) {
        this.id = id;
    }
}
