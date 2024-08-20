package com.service.users.migow.migow_users_service.domain.interfaces.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;

public interface FriendshipRequestRepository {
    Optional<FriendshipRequest> getFriendshipRequestById(FriendshipRequestPK id);

    void createFriendshipRequest(FriendshipRequest obj);

    void deleteFriendshipRequest(FriendshipRequestPK id);

    boolean existFriendshipRequest(UUID ownerId, UUID targetId);

    Page<FriendshipRequest> getAllOwnerFriendshipRequest(UUID userId, Pageable pageable);

    Page<FriendshipRequest> getAllTargetFriendshipRequest(UUID userId, Pageable pageable);
}
