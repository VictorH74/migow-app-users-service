package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

public interface DeleteFriendshipUseCase {
    void execute(UUID userId, UUID friendId);
}
