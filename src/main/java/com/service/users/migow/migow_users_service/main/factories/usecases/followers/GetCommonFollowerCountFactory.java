package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetCommonFollowerCountUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetFullFollowersByFollowingIdUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.GetCommonFollowerCount;

@Configuration
public class GetCommonFollowerCountFactory {
    @Bean
    public GetCommonFollowerCountUseCase getCommonFollowerCountUseCase(GetUserByIdUseCase getUserByIdUseCase,
            GetFullFollowersByFollowingIdUseCase getFullFollowersByFollowingIdUseCase,
            GetIsFollowerStatusUseCase getIsFollowerStatusUseCase) {
        return new GetCommonFollowerCount(getUserByIdUseCase, getFullFollowersByFollowingIdUseCase,
                getIsFollowerStatusUseCase);
    }
}
