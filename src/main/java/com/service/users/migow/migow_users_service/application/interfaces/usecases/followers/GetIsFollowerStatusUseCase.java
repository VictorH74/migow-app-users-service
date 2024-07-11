package com.service.users.migow.migow_users_service.application.interfaces.usecases.followers;

import java.util.UUID;

public interface GetIsFollowerStatusUseCase {
    boolean execute(UUID followerId, UUID followedId);
}
