package com.service.users.migow.migow_users_service.application.interfaces.usecases.users;

import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public interface GetUserByUsernameUseCase {
    SimpleUserDTO execute(String username);

}
