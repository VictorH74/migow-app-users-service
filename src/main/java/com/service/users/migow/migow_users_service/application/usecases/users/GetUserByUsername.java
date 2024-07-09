package com.service.users.migow.migow_users_service.application.usecases.users;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByUsernameUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;
import com.service.users.migow.migow_users_service.infra.http.handlers.UserNotFounException;

@Component
public class GetUserByUsername implements GetUserByUsernameUseCase {
    private final UserRepository userRepository;

    public GetUserByUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SimpleUserDTO execute(String username) {
        User user = userRepository.getUserByUsername(username).orElseThrow(
                () -> new UserNotFounException(String.format("User with username '%s' not found", username)));
        return new SimpleUserDTO(user);
    }

}
