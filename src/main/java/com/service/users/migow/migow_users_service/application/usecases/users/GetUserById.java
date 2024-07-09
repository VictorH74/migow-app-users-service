package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;
import com.service.users.migow.migow_users_service.infra.http.handlers.UserNotFounException;

public class GetUserById implements GetUserByIdUseCase {
    private final UserRepository userRepository;

    public GetUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SimpleUserDTO execute(UUID id) {
        User user = userRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFounException("User with id '" + id + "' not found"));
        return new SimpleUserDTO(user);
    }

}
