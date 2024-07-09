package com.service.users.migow.migow_users_service.application.usecases.users;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByLoginUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.handlers.UserNotFounException;

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
