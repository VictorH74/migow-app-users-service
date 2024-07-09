package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByLoginUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.GetUserByLogin;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class GetUserByLoginFactory {
    @Bean
    public GetUserByLoginUseCase getUserByLoginUseCase(UserRepositoryImpl userRepository) {
        return new GetUserByLogin(userRepository);
    }
}
