package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaFriendshipRepository;

@Repository
public class FriendshipRepositoryImpl implements FriendshipRepository {
    private final JpaFriendshipRepository jpaFriendshipRepository;

    @Override
    public List<Friendship> createManyFriendship(List<Friendship> objs) {
        return jpaFriendshipRepository.saveAll(objs);
    }

    public FriendshipRepositoryImpl(JpaFriendshipRepository jpaFriendshipRepository) {
        this.jpaFriendshipRepository = jpaFriendshipRepository;
    }

    @Override
    public Friendship createFriendship(Friendship obj) {
        return jpaFriendshipRepository.save(obj);
    }

    @Override
    public void deleteFriendship(FriendshipPK id) {
        jpaFriendshipRepository.deleteById(id);
    }

    @Override
    public Page<Friendship> getAllUserFriendByUsername(UUID userId, String usernamePrefix, Pageable pageable) {
        return jpaFriendshipRepository.findFriendshipsByUserId(userId, usernamePrefix, pageable);
    }

    @Override
    public boolean getFriendshipStatus(UUID userId, UUID friendId) {
        return jpaFriendshipRepository.isFriendship(userId, friendId);
    }

    @Override
    public boolean existByUserIds(UUID userId1, UUID userId2) {
        return jpaFriendshipRepository.existByUserIds(userId1, userId2);
    }

}
