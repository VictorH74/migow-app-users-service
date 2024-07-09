package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.List;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.CreateManyFollowerUseCase;
import com.service.users.migow.migow_users_service.domain.entities.Follower;

public class CreateManyFollower implements CreateManyFollowerUseCase {
    private final FollowerRepository followerRepository;

    public CreateManyFollower(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> execute(List<Follower> objs) {
        return followerRepository.createManyFollower(objs);
    }

}
