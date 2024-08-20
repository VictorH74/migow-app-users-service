package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.friendship_requests.ResponseFriendshipRequestDTO;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.GetAllTargetFriendshipRequestUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAllTargetFriendshipRequest implements GetAllTargetFriendshipRequestUseCase {
    private final FriendshipRequestRepository friendshipRequestRepository;

    @Override
    public Page<ResponseFriendshipRequestDTO> execute(UUID userId, Pageable pageable) {
        return friendshipRequestRepository.getAllTargetFriendshipRequest(userId, pageable)
                .map(f -> new ResponseFriendshipRequestDTO(f.getId().getOwner()));
    }
}
