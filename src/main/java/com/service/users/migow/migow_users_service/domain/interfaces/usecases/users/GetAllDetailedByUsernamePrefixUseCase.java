package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserWithIsFriendPropDTO;
import com.service.users.migow.migow_users_service.infra.helpers.CustomPage;

public interface GetAllDetailedByUsernamePrefixUseCase {
    CustomPage<SimpleUserWithIsFriendPropDTO> execute(String usernamePrefix, UUID userId, Pageable pageable);
}
