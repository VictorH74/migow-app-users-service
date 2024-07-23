package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import com.service.users.migow.migow_users_service.application.dtos.friendships.CreateDeleteFriendshipDTO;

public interface DeleteFriendshipUseCase {
    void execute(CreateDeleteFriendshipDTO obj);
}
