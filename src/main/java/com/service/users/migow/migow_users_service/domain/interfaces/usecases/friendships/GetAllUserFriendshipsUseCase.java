package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;

public interface GetAllUserFriendshipsUseCase {
    Page<SimpleUserDTO> execute(UUID userId, String usernamePrefix, Pageable pageable);
}
