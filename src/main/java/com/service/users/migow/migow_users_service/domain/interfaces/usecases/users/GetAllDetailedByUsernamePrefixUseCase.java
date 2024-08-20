package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserWithFriendshipStatusDTO;
import com.service.users.migow.migow_users_service.infra.helpers.CustomPage;

public interface GetAllDetailedByUsernamePrefixUseCase {
    CustomPage<SimpleUserWithFriendshipStatusDTO> execute(String usernamePrefix, UUID userId, Pageable pageable);
}
