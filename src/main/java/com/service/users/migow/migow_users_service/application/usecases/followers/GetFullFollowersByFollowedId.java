package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetFullFollowersByFollowedIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.Follower;

@Component
public class GetFullFollowersByFollowedId implements GetFullFollowersByFollowedIdUseCase {

    private final FollowerRepository followerRepository;

    public GetFullFollowersByFollowedId(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> execute(UUID followedId) {
        return followerRepository.getAllFollowersByFollowedId(followedId, "", Pageable.unpaged()).getContent();
    }

}
