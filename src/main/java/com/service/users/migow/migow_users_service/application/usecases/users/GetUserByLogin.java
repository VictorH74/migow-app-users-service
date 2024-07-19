package com.service.users.migow.migow_users_service.application.usecases.users;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.user.UserNotFounException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByLoginUseCase;

@Component
public class GetUserByLogin implements GetUserByLoginUseCase {
    private final UserRepository userRepository;

    public GetUserByLogin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(String login) {
        return userRepository.getUserByLogin(login).orElseThrow(() -> new UserNotFounException());
    }

}
