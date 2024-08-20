package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;

public interface JpaFriendshipRequestRepository extends JpaRepository<FriendshipRequest, FriendshipRequestPK> {
    @Query("SELECT f FROM FriendshipRequest f WHERE f.id.target.id = :userId")
    public Page<FriendshipRequest> findAllTargetFriendshipRequest(UUID userId, Pageable pageable);
    
    @Query("SELECT f FROM FriendshipRequest f WHERE f.id.owner.id = :userId")
    public Page<FriendshipRequest> findAllOwnerFriendshipRequest(UUID userId, Pageable pageable);

    // @Query("SELECT COUNT(f) > 0 FROM Friendship f WHERE (f.id.user.id = :userId1 AND f.id.friendUser.id = :userId2) OR (f.id.user.id = :userId2 AND f.id.friendUser.id = :userId1)")
    @Query("SELECT COUNT(f) > 0 FROM FriendshipRequest f WHERE f.id.owner.id = :ownerId AND f.id.target.id = :targetId")
    public boolean existByUserIds(UUID ownerId, UUID targetId);

}
