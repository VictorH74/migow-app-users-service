package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.domain.entities.Follower;
import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaFollowerRepository;

@Repository
public class FollowerRepositoryImpl implements FollowerRepository {
    private final JpaFollowerRepository jpaFollowerRepository;

    @Override
    public List<Follower> createManyFollower(List<Follower> objs) {
        return jpaFollowerRepository.saveAll(objs);
    }

    public FollowerRepositoryImpl(JpaFollowerRepository jpaFollowerRepository) {
        this.jpaFollowerRepository = jpaFollowerRepository;
    }

    @Override
    public Follower createFollower(Follower obj) {
        return jpaFollowerRepository.save(obj);
    }

    @Override
    public void deleteFollowerById(FollowerPK id) {
        jpaFollowerRepository.deleteById(id);
    }

    @Override
    public Page<Follower> getAllFollowersByFollowingId(UUID followingId, String usernamePrefix, Pageable pageable) {
        return jpaFollowerRepository.findFollowersByFollowingId(followingId, usernamePrefix, pageable);
    }

    @Override
    public boolean getIsFollowerStatus(UUID followerId, UUID followingId) {
        return jpaFollowerRepository.isFollower(followerId, followingId);
    }

}
