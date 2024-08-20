package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.friendship_requests.CreateDeleteFriendshipRequestDTO;
import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.CreateFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateFriendshipRequest implements CreateFriendshipRequestUseCase {
    private final FriendshipRequestRepository friendshipRequestRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public void execute(CreateDeleteFriendshipRequestDTO obj) {
        FriendshipRequest f = new FriendshipRequest();
        User owner = getUserByIdUseCase.execute(obj.getOwnerId()).toUser();
        User target = getUserByIdUseCase.execute(obj.getTargetId()).toUser();
        FriendshipRequestPK pk = new FriendshipRequestPK();
        pk.setOwner(owner);
        pk.setTarget(target);
        f.setId(pk);

        friendshipRequestRepository.createFriendshipRequest(f);
    }

}
