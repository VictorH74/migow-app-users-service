package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.GetUserById;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class GetUserByIdFactory {
    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepositoryImpl userRepository) {
        return new GetUserById(userRepository);
    }
}
