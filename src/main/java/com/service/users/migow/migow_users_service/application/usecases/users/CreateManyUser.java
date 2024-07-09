package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.CreateManyUserUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;

@Component
public class CreateManyUser implements CreateManyUserUseCase {
    private final UserRepository userRepository;

    public CreateManyUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> execute(List<User> objs) {
        return userRepository.createManyUser(objs);
    }

}
