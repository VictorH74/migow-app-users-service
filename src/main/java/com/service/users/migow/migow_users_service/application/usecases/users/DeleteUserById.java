package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.DeleteUserByIdUseCase;

@Component
public class DeleteUserById implements DeleteUserByIdUseCase {
    private final UserRepository userRepository;

    public DeleteUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(UUID id) {
        userRepository.deleteUserById(id);

    }

}
