package com.service.users.migow.migow_users_service.application.interfaces.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.domain.entities.Follower;
import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;

public interface FollowerRepository {
    List<Follower> createManyFollower(List<Follower> objs);

    Follower createFollower(Follower obj);

    Page<Follower> getAllFollowersByFollowedId(UUID followedId, String usernamePrefix, Pageable pageable);

    boolean getIsFollowerStatus(UUID followerId, UUID followedId);

    void deleteFollowerById(FollowerPK id);

}
