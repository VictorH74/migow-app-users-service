package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.users.migow.migow_users_service.domain.entities.Follower;
import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;

public interface JpaFollowerRepository extends JpaRepository<Follower, FollowerPK> {

    @Query("SELECT f FROM Follower f WHERE f.id.followingUser.id=:followingId AND f.id.followerUser.username LIKE CONCAT(:usernamePrefix, '%')")
    public Page<Follower> findFollowersByFollowingId(UUID followingId, String usernamePrefix, Pageable pageable);

    @Query("SELECT COUNT(f) > 0 FROM Follower f WHERE f.id.followerUser.id = :followerId AND f.id.followingUser.id = :followingId")
    public boolean isFollower(UUID followerId, UUID followingId);

}
