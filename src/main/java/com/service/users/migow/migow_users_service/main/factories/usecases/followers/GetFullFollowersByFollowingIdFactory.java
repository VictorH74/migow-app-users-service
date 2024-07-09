package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetFullFollowersByFollowingIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.GetFullFollowersByFollowingId;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.FollowerRepositoryImpl;

@Configuration
public class GetFullFollowersByFollowingIdFactory {
    @Bean
    public GetFullFollowersByFollowingIdUseCase getFullFollowersByFollowingIdUseCase(
            FollowerRepositoryImpl followerRepository) {
        return new GetFullFollowersByFollowingId(followerRepository);
    }
}
