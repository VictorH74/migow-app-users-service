package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;

public interface JpaFriendshipRepository extends JpaRepository<Friendship, FriendshipPK> {
    @Query("SELECT f FROM Friendship f WHERE (f.id.friendUser.id=:userId OR f.id.user.id=:userId) AND f.id.user.username LIKE CONCAT(:usernamePrefix, '%')")
    public Page<Friendship> findFriendshipsByUserId(UUID userId, String usernamePrefix, Pageable pageable);

    @Query("SELECT COUNT(f) > 0 FROM Friendship f WHERE (f.id.user.id = :userId AND f.id.friendUser.id = :friendId) OR (f.id.user.id = :friendId AND f.id.friendUser.id = :userId)")
    public boolean isFriendship(UUID userId, UUID friendId);

    @Query("SELECT COUNT(f) > 0 FROM Friendship f WHERE (f.id.user.id = :userId1 AND f.id.friendUser.id = :userId2) OR (f.id.user.id = :userId2 AND f.id.friendUser.id = :userId1)")
    public boolean existByUserIds(UUID userId1, UUID userId2);

    @Query("SELECT f FROM Friendship f WHERE (f.id.user.id = :userId1 AND f.id.friendUser.id = :userId2) OR (f.id.user.id = :userId2 AND f.id.friendUser.id = :userId1)")
    public Optional<Friendship> findFriendshipByTwoUsers(UUID userId1, UUID userId2);
}
