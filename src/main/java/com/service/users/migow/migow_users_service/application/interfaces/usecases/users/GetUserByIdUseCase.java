package com.service.users.migow.migow_users_service.application.interfaces.usecases.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public interface GetUserByIdUseCase {
    SimpleUserDTO execute(UUID id);
}
