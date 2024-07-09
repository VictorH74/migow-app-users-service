package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.UpdateUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.UpdateUserById;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class UpdateUserByIdFactory {
    @Bean
    public UpdateUserByIdUseCase updateUserByIdUseCase(UserRepositoryImpl userRepository) {
        return new UpdateUserById(userRepository);
    }
}
