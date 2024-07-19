package com.service.users.migow.migow_users_service.application.usecases.friendships;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class GetFriendshipStatus implements GetFriendshipStatusUseCase {

    private final FriendshipRepository friendshipRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public GetFriendshipStatus(FriendshipRepository friendshipRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.friendshipRepository = friendshipRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public boolean execute(UUID userId, UUID friendId) {
        getUserByIdUseCase.execute(userId);
        getUserByIdUseCase.execute(friendId);
        return friendshipRepository.getFriendshipStatus(userId, friendId);
    }

}
