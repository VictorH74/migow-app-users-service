package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRequestRepository;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaFriendshipRequestRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class FriendshipRequestRepositoryImpl implements FriendshipRequestRepository {
    private final JpaFriendshipRequestRepository jpaFriendshipRequestRepository;

    @Override
    public Optional<FriendshipRequest> getFriendshipRequestById(FriendshipRequestPK id) {
        return jpaFriendshipRequestRepository.findById(id);
    }

    @Override
    public void createFriendshipRequest(FriendshipRequest obj) {
        jpaFriendshipRequestRepository.save(obj);
    }

    @Override
    public void deleteFriendshipRequest(FriendshipRequestPK id) {
        jpaFriendshipRequestRepository.deleteById(id);
    }

    @Override
    public boolean existFriendshipRequest(UUID ownerId, UUID targetId) {
        return jpaFriendshipRequestRepository.existByUserIds(ownerId, targetId);
    }

    @Override
    public Page<FriendshipRequest> getAllOwnerFriendshipRequest(UUID userId, Pageable pageable) {
        return jpaFriendshipRequestRepository.findAllOwnerFriendshipRequest(userId, pageable);
    }

    @Override
    public Page<FriendshipRequest> getAllTargetFriendshipRequest(UUID userId, Pageable pageable) {
        return jpaFriendshipRequestRepository.findAllTargetFriendshipRequest(userId, pageable);
    }

}
