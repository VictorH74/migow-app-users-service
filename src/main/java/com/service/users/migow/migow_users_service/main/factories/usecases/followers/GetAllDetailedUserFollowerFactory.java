package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllDetailedUserFollowerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.GetAllDetailedUserFollower;

@Configuration
public class GetAllDetailedUserFollowerFactory {
    @Bean
    public GetAllDetailedUserFollowerUseCase getAllDetailedUserFollowerUseCase(
            GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase,
            GetIsFollowerStatusUseCase getIsFollowerStatusUseCase) {
        return new GetAllDetailedUserFollower(getAllUserByUsernamePrefixUseCase, getIsFollowerStatusUseCase);
    }
}
