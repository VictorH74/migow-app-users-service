package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllFollowersByFollowedIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

@Component
public class GetAllFollowersByFollowedId implements GetAllFollowersByFollowedIdUseCase {

    private final FollowerRepository followerRepository;

    public GetAllFollowersByFollowedId(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public Page<SimpleUserDTO> execute(UUID followedId, String usernamePrefix, Pageable pageable) {
        return followerRepository.getAllFollowersByFollowedId(followedId, usernamePrefix, pageable).map(follower -> {
            User user = follower.getId().getFollowerUser();
            SimpleUserDTO userDTO = new SimpleUserDTO(user);
            return userDTO;
        });
    }

}
