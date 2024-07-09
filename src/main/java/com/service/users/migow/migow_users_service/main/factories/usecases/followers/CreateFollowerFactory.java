package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.CreateFollowerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.CreateFollower;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.FollowerRepositoryImpl;

@Configuration
public class CreateFollowerFactory {
    @Bean
    public CreateFollowerUseCase createFollowerUseCase(FollowerRepositoryImpl followerRepository,
            GetUserByIdUseCase getUserByIdUseCase) {
        return new CreateFollower(followerRepository, getUserByIdUseCase);
    }
}
