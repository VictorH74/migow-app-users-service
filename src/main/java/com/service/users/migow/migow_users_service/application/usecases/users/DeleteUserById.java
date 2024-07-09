package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.DeleteUserByIdUseCase;

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
