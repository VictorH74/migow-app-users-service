package com.service.users.migow.migow_users_service.application.usecases.friendships;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.enums.FriendshipStatusEnum;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.ExistFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetFriendshipStatus implements GetFriendshipStatusUseCase {
    private final FriendshipRepository friendshipRepository;
    private final ExistFriendshipRequestUseCase existFriendshipRequestUseCase;

    @Override
    public FriendshipStatusEnum execute(UUID userId, UUID targetId) {

        boolean isFriend = friendshipRepository.getFriendshipStatus(userId, targetId);
        if (isFriend) return FriendshipStatusEnum.IS_FRIEND;

        boolean existFriendshipRequest = existFriendshipRequestUseCase.execute(userId, targetId);
        if (existFriendshipRequest) return FriendshipStatusEnum.PENDING;

        return FriendshipStatusEnum.IS_NOT_FRIEND;
    }

}
