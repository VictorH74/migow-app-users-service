package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.DeleteUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.DeleteUserById;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class DeleteUserByIdFactory {
    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(UserRepositoryImpl userRepository) {
        return new DeleteUserById(userRepository);
    }

}
