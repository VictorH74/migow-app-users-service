package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.List;
import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;

public interface GetFullUserFriendshipUseCase {
    List<Friendship> execute(UUID userId);
}
