package com.service.users.migow.migow_users_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;

public interface FriendshipRepository {
    List<Friendship> createManyFriendship(List<Friendship> objs);

    void createFriendship(Friendship obj);

    Page<Friendship> getAllUserFriendByUsername(UUID userId, String usernamePrefix, Pageable pageable);

    boolean getFriendshipStatus(UUID userId, UUID friendId);

    boolean existByUserIds(UUID userId1, UUID userId2);

    Optional<Friendship> getFriendshipByTwoUsers(UUID userId1, UUID userId2);

    void deleteFriendship(FriendshipPK id);

}
