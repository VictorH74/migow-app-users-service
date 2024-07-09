package com.service.users.migow.migow_users_service.application.interfaces.usecases.followers;

import java.util.List;
import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.Follower;

public interface GetFullFollowersByFollowingIdUseCase {
    List<Follower> execute(UUID followingId);
}
