package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.GetAllUserByUsernamePrefix;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class GetAllUserByUsernamePrefixFactory {
    @Bean
    public GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase(UserRepositoryImpl userRepository) {
        return new GetAllUserByUsernamePrefix(userRepository);
    }

}
