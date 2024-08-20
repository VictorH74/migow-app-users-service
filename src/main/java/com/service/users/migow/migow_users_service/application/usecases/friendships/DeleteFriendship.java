package com.service.users.migow.migow_users_service.application.usecases.friendships;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.friendships.CreateDeleteFriendshipDTO;
import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.exceptions.friendships.NotFoundFriendshipException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.DeleteFriendshipUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteFriendship implements DeleteFriendshipUseCase {
    private final FriendshipRepository friendshipRepository;

    @Override
    public void execute(CreateDeleteFriendshipDTO obj) {
        Friendship f = friendshipRepository
                .getFriendshipByTwoUsers(obj.getOwnerId(), obj.getTargetId())
                .orElseThrow(() -> new NotFoundFriendshipException());

        friendshipRepository.deleteFriendship(f.getId());
    }

}
