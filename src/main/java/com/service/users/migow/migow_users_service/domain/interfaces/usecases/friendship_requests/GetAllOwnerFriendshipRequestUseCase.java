package com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.dtos.friendship_requests.ResponseFriendshipRequestDTO;

public interface GetAllOwnerFriendshipRequestUseCase {
    public Page<ResponseFriendshipRequestDTO> execute(UUID userId, Pageable pageable);
}
