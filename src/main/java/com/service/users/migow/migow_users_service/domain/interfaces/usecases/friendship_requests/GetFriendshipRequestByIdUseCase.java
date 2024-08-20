package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests;

import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;

public interface GetFriendshipRequestByIdUseCase {
    public FriendshipRequest execute(FriendshipRequestPK id);
}
