package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;
import com.service.users.migow.migow_users_service.domain.exceptions.friendship_requests.NotFoundFriendshipRequestException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.GetFriendshipRequestByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetFriendshipRequestById implements GetFriendshipRequestByIdUseCase {
    private final FriendshipRequestRepository friendshipRequestRepository;

    @Override
    public FriendshipRequest execute(FriendshipRequestPK id) {
        return friendshipRequestRepository.getFriendshipRequestById(id)
                .orElseThrow(() -> new NotFoundFriendshipRequestException());
    }

}
