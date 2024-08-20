package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.enums.FriendshipStatusEnum;

public interface GetFriendshipStatusUseCase {
    FriendshipStatusEnum execute(UUID userId, UUID friendId);
}
