package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.DeleteFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeleteFriendshipRequest implements DeleteFriendshipRequestUseCase {

    private final FriendshipRequestRepository friendshipRequestRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public void execute(UUID ownerId, UUID targetId) {
        FriendshipRequestPK id = new FriendshipRequestPK();

        User owner = getUserByIdUseCase.execute(ownerId).toUser();
        User target = getUserByIdUseCase.execute(targetId).toUser();

        id.setOwner(owner);
        id.setTarget(target);

        friendshipRequestRepository.deleteFriendshipRequest(id);
    }

}
