package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests;

import java.util.UUID;

public interface DeleteFriendshipRequestUseCase {

    public void execute(UUID ownerId, UUID targetId);
}
