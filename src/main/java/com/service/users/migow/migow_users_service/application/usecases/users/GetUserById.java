package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.user.UserNotFounException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
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
