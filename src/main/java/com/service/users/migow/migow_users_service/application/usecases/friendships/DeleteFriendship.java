package com.service.users.migow.migow_users_service.application.usecases.friendships;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.friendships.CreateDeleteFriendshipDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;
import com.service.users.migow.migow_users_service.domain.exceptions.friendships.NotFoundFriendshipException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.DeleteFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteFriendship implements DeleteFriendshipUseCase {
    private final FriendshipRepository friendshipRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public void execute(CreateDeleteFriendshipDTO obj) {
        boolean exists = friendshipRepository.existByUserIds(obj.getUserId(), obj.getFriendId());

        if (!exists)
            throw new NotFoundFriendshipException();

        User user = getUserByIdUseCase.execute(obj.getUserId()).toUser();
        User friendUser = getUserByIdUseCase.execute(obj.getFriendId()).toUser();

        FriendshipPK friendshipPK = new FriendshipPK();
        friendshipPK.setUser(user);
        friendshipPK.setFriendUser(friendUser);

        friendshipRepository.deleteFriendship(friendshipPK);
    }

}
