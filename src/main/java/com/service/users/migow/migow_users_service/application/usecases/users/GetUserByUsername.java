package com.service.users.migow.migow_users_service.application.usecases.users;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.users.ProfileUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.user.UserNotFounException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByUsernameUseCase;

@Component
public class GetUserByUsername implements GetUserByUsernameUseCase {
    private final UserRepository userRepository;

    public GetUserByUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ProfileUserDTO execute(String username) {
        User user = userRepository.getUserByUsername(username).orElseThrow(
                () -> new UserNotFounException(String.format("User with username '%s' not found", username)));
        return new ProfileUserDTO(user);
    }

}
