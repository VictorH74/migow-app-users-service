package com.service.users.migow.migow_users_service.application.interfaces.usecases.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public interface GetAllUserByUsernamePrefixUseCase {
    Page<SimpleUserDTO> execute(String usernamePrefix, Pageable pageable);
}
