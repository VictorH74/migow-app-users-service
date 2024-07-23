package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import com.service.users.migow.migow_users_service.application.dtos.users.CreateUserDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;

public interface CreateUserUseCase {
    SimpleUserDTO execute(CreateUserDTO obj);
}
