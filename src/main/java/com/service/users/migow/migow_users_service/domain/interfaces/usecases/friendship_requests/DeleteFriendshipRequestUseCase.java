package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests;

import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;

public interface DeleteFriendshipRequestUseCase {
    public void execute(FriendshipRequestPK id);
}
