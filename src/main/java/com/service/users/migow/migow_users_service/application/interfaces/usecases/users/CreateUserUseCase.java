package com.service.users.migow.migow_users_service.application.interfaces.usecases.users;

import com.service.users.migow.migow_users_service.domain.entities.User;

public interface CreateUserUseCase {
    User execute(User obj);
}
