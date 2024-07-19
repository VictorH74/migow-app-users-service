package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.List;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;

public interface CreateManyFriendshipUseCase {
    List<Friendship> execute(List<Friendship> objs);

}
