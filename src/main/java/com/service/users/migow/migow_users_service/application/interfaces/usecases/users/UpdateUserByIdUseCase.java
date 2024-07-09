package com.service.users.migow.migow_users_service.application.interfaces.usecases.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.UpdateUserDTO;

public interface UpdateUserByIdUseCase {
    User execute(UUID id, UpdateUserDTO obj);
}
