package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshiptCommonCountDTO;

public interface GetCommonFriendshipCountUseCase {
    FriendshiptCommonCountDTO execute(UUID userId, UUID targetUser);
}
