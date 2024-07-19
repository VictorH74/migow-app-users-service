package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import com.service.users.migow.migow_users_service.domain.entities.User;

public interface GetUserByLoginUseCase {
    User execute(String login);
}
