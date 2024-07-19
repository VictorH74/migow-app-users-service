package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;

public interface CreateFriendshipUseCase {
    Friendship execute(UUID userId, UUID friendId);
}
