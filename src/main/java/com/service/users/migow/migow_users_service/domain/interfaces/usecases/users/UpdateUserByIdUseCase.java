package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.dtos.users.UpdateUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface UpdateUserByIdUseCase {
    User execute(UUID id, UpdateUserDTO obj);
}
