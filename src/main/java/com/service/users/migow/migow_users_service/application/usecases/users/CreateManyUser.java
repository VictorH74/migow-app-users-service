package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.CreateManyUserUseCase;

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
