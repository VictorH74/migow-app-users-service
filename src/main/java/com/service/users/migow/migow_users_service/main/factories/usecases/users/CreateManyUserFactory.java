package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.CreateManyUserUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.CreateManyUser;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class CreateManyUserFactory {
    @Bean
    public CreateManyUserUseCase createManyUserUseCase(UserRepositoryImpl userRepository) {
        return new CreateManyUser(userRepository);
    }
}
