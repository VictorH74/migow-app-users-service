package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllFollowersByFollowingIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public class GetAllFollowersByFollowingId implements GetAllFollowersByFollowingIdUseCase {

    private final FollowerRepository followerRepository;

    public GetAllFollowersByFollowingId(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public Page<SimpleUserDTO> execute(UUID followingId, String usernamePrefix, Pageable pageable) {
        return followerRepository.getAllFollowersByFollowingId(followingId, usernamePrefix, pageable).map(follower -> {
            User user = follower.getId().getFollowerUser();
            SimpleUserDTO userDTO = new SimpleUserDTO(user);
            return userDTO;
        });
    }

}
