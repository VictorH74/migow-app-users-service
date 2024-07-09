package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.CreateFollowerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.Follower;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;

public class CreateFollower implements CreateFollowerUseCase {

    private final FollowerRepository followerRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public CreateFollower(FollowerRepository followerRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.followerRepository = followerRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public Follower execute(UUID followerId, UUID followingId) {
        FollowerPK followerPK = new FollowerPK();
        User followerUser = getUserByIdUseCase.execute(followerId).toUser();
        User followingUser = getUserByIdUseCase.execute(followingId).toUser();
        followerPK.setFollowerUser(followerUser);
        followerPK.setFollowingUser(followingUser);
        Follower f = new Follower();
        f.setId(followerPK);
        return followerRepository.createFollower(f);
    }

}
