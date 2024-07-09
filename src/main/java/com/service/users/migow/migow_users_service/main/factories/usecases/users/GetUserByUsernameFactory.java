package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByUsernameUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.GetUserByUsername;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class GetUserByUsernameFactory {
    @Bean
    public GetUserByUsernameUseCase getUserByUsernameUseCase(UserRepositoryImpl userRepository) {
        return new GetUserByUsername(userRepository);
    }
}
