package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;

public interface GetUserByIdUseCase {
    SimpleUserDTO execute(UUID id);
}
