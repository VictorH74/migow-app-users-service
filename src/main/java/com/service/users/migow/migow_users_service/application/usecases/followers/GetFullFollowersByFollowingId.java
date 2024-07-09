package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetFullFollowersByFollowingIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.Follower;

public class GetFullFollowersByFollowingId implements GetFullFollowersByFollowingIdUseCase {

    private final FollowerRepository followerRepository;

    public GetFullFollowersByFollowingId(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> execute(UUID followingId) {
        return followerRepository.getAllFollowersByFollowingId(followingId, "", Pageable.unpaged()).getContent();
    }

}
