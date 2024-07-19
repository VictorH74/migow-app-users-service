package com.service.users.migow.migow_users_service.application.usecases.friendships;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;
import com.service.users.migow.migow_users_service.domain.exceptions.friendships.ExistingFriendshipException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.CreateFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class CreateFriendship implements CreateFriendshipUseCase {

    private final FriendshipRepository friendshipRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public CreateFriendship(FriendshipRepository friendshipRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.friendshipRepository = friendshipRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public Friendship execute(UUID userId, UUID friendId) {
        boolean exists = friendshipRepository.existByUserIds(userId, friendId);

        User user = getUserByIdUseCase.execute(userId).toUser();
        User friendUser = getUserByIdUseCase.execute(friendId).toUser();

        if (exists)
            throw new ExistingFriendshipException();

        FriendshipPK friendshipPK = new FriendshipPK();
        friendshipPK.setUser(user);
        friendshipPK.setFriendUser(friendUser);
        Friendship f = new Friendship();
        f.setId(friendshipPK);
        return friendshipRepository.createFriendship(f);
    }

}
