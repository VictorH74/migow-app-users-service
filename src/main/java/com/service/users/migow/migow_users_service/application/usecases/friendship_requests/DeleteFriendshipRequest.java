package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.DeleteFriendshipRequestUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeleteFriendshipRequest implements DeleteFriendshipRequestUseCase {
    private final FriendshipRequestRepository friendshipRequestRepository;

    @Override
    public void execute(FriendshipRequestPK id) {
        friendshipRequestRepository.deleteFriendshipRequest(id);
    }

}
