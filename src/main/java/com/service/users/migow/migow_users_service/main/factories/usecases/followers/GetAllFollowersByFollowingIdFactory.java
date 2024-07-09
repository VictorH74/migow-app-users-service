package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllFollowersByFollowingIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.GetAllFollowersByFollowingId;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.FollowerRepositoryImpl;

@Configuration
public class GetAllFollowersByFollowingIdFactory {
    @Bean
    public GetAllFollowersByFollowingIdUseCase getAllFollowersByFollowingIdUseCase(
            FollowerRepositoryImpl followerRepository) {
        return new GetAllFollowersByFollowingId(followerRepository);
    }
}
