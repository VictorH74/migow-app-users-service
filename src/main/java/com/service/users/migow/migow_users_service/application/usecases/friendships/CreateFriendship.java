package com.service.users.migow.migow_users_service.application.usecases.friendships;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.friendships.CreateDeleteFriendshipDTO;
import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;
import com.service.users.migow.migow_users_service.domain.exceptions.friendships.ExistingFriendshipException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.CreateFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateFriendship implements CreateFriendshipUseCase {
    private final FriendshipRepository friendshipRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public void execute(CreateDeleteFriendshipDTO obj) {
        boolean exists = friendshipRepository.existByUserIds(obj.getOwnerId(), obj.getTargetId());

        if (exists)
            throw new ExistingFriendshipException();

        User user = getUserByIdUseCase.execute(obj.getOwnerId()).toUser();
        User friendUser = getUserByIdUseCase.execute(obj.getTargetId()).toUser();

        FriendshipPK friendshipPK = new FriendshipPK();
        friendshipPK.setUser(user);
        friendshipPK.setFriendUser(friendUser);
        Friendship f = new Friendship();
        f.setId(friendshipPK);
        friendshipRepository.createFriendship(f);
    }

}
