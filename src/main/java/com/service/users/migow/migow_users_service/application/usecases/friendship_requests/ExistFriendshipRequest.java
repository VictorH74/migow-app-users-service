package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.ExistFriendshipRequestUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ExistFriendshipRequest implements ExistFriendshipRequestUseCase {
    private final FriendshipRequestRepository friendshipRequestRepository;

    @Override
    public boolean execute(UUID ownerId, UUID targetId) {
        return friendshipRequestRepository.existFriendshipRequest(ownerId, targetId);
    }

}
