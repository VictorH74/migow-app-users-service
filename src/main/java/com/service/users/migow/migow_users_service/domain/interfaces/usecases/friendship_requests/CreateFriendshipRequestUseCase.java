package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests;

import com.service.users.migow.migow_users_service.application.dtos.friendship_requests.CreateDeleteFriendshipRequestDTO;

public interface CreateFriendshipRequestUseCase {
    public void execute(CreateDeleteFriendshipRequestDTO obj);
}
