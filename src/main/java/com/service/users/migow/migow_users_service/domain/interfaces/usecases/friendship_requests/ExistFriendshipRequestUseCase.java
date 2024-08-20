package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests;

import java.util.UUID;

public interface ExistFriendshipRequestUseCase {
    public boolean execute(UUID ownerId, UUID targetId);
}
