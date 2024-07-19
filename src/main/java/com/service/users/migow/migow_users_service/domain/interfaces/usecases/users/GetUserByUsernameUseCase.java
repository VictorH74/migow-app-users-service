package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import com.service.users.migow.migow_users_service.application.dtos.users.ProfileUserDTO;

public interface GetUserByUsernameUseCase {
    ProfileUserDTO execute(String username);

}
