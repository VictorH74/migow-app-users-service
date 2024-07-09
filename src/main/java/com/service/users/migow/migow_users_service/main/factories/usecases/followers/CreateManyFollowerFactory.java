package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.CreateManyFollowerUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.CreateManyFollower;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.FollowerRepositoryImpl;

@Configuration
public class CreateManyFollowerFactory {
    @Bean
    public CreateManyFollowerUseCase createManyFollowerUseCase(FollowerRepositoryImpl followerRepositoryImpl) {
        return new CreateManyFollower(followerRepositoryImpl);
    }
}
