package com.service.users.migow.migow_users_service.application.usecases.friendships;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFullUserFriendshipUseCase;

@Component
public class GetFullUserFriendship implements GetFullUserFriendshipUseCase {

    private final FriendshipRepository friendshipRepository;

    public GetFullUserFriendship(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    @Override
    public List<Friendship> execute(UUID userId) {
        return friendshipRepository.getAllUserFriendByUsername(userId, "", Pageable.unpaged()).getContent();
    }

}
