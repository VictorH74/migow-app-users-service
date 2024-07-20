package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.infra.helpers.CustomPage;

public interface GetAllUserByUsernamePrefixUseCase {
    CustomPage<SimpleUserDTO> execute(String usernamePrefix, UUID userId, Pageable pageable);
}
