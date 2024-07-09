package com.service.users.migow.migow_users_service.application.interfaces.usecases.followers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.infra.http.dtos.FollowerUserDTO;

public interface GetAllDetailedUserFollowerUseCase {
    Page<FollowerUserDTO> execute(String usernamePrefix, UUID followingId, Pageable pageable);
}
