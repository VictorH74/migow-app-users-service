package com.service.users.migow.migow_users_service.application.usecases.friendships;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetAllUserFriendshipsUseCase;

@Component
public class GetAllUserFriendship implements GetAllUserFriendshipsUseCase {

    private final FriendshipRepository friendshipRepository;

    public GetAllUserFriendship(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    @Override
    public Page<SimpleUserDTO> execute(UUID userId, String usernamePrefix, Pageable pageable) {
        return friendshipRepository.getAllUserFriendByUsername(userId, usernamePrefix, pageable).map(friendship -> {
            User user = friendship.getId().getUser();

            SimpleUserDTO userDTO = new SimpleUserDTO(user.getId().equals(userId) ? friendship.getId().getFriendUser() : user);
            return userDTO;
        });
    }

}
