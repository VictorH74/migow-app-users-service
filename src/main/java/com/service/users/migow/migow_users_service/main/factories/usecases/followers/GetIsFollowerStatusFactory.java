package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.GetIsFollowerStatus;

@Configuration
public class GetIsFollowerStatusFactory {
    @Bean
    public GetIsFollowerStatusUseCase GetIsFollowerStatusUseCase(FollowerRepository followerRepository,
            GetUserByIdUseCase getUserByIdUseCase) {
        return new GetIsFollowerStatus(followerRepository, getUserByIdUseCase);
    }
}
