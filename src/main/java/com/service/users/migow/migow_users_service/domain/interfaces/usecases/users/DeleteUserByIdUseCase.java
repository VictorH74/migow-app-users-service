package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.UUID;

public interface DeleteUserByIdUseCase {
    void execute(UUID id);
}
