package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;

public class GetIsFollowerStatus implements GetIsFollowerStatusUseCase {

    private final FollowerRepository followerRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public GetIsFollowerStatus(FollowerRepository followerRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.followerRepository = followerRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public boolean execute(UUID followerId, UUID followingId) {
        getUserByIdUseCase.execute(followerId);
        getUserByIdUseCase.execute(followingId);
        return followerRepository.getIsFollowerStatus(followerId, followingId);
    }

}
