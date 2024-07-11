package com.service.users.migow.migow_users_service.application.interfaces.usecases.followers;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.Follower;

public interface CreateFollowerUseCase {
    Follower execute(UUID followerId, UUID followedId);
}
