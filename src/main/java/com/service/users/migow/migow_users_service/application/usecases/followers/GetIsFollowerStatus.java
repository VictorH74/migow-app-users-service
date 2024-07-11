package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class GetIsFollowerStatus implements GetIsFollowerStatusUseCase {

    private final FollowerRepository followerRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public GetIsFollowerStatus(FollowerRepository followerRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.followerRepository = followerRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public boolean execute(UUID followerId, UUID followedId) {
        getUserByIdUseCase.execute(followerId);
        getUserByIdUseCase.execute(followedId);
        return followerRepository.getIsFollowerStatus(followerId, followedId);
    }

}
