package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.UpdateUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.UpdateUserDTO;
import com.service.users.migow.migow_users_service.infra.http.handlers.UserNotFounException;

@Component
public class UpdateUserById implements UpdateUserByIdUseCase {

    private final UserRepository userRepository;

    public UpdateUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(UUID id, UpdateUserDTO obj) {
        User user = userRepository.getUserById(id).orElseThrow(() -> new UserNotFounException());
        user.setUsername(obj.getUsername());
        user.setPassword(obj.getPassword());
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setProfileImageUrl(obj.getProfileImageUrl());
        user.setBgImageUrl(obj.getBgImageUrl());
        return userRepository.createUpdateUser(user);
    }

}
