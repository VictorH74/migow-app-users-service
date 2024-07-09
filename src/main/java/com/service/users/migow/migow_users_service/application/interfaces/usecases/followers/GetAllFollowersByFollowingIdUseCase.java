package com.service.users.migow.migow_users_service.application.interfaces.usecases.followers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public interface GetAllFollowersByFollowingIdUseCase {
    Page<SimpleUserDTO> execute(UUID followingId, String usernamePrefix, Pageable pageable);
}
