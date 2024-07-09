package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.FollowerRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.DeleteFollowerByIdUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;

@Component
public class DeleteFollowerById implements DeleteFollowerByIdUseCase {

    private final FollowerRepository followerRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public DeleteFollowerById(FollowerRepository followerRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.followerRepository = followerRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public void execute(UUID followerId, UUID followingId) {
        FollowerPK followerPK = new FollowerPK();
        User followerUser = getUserByIdUseCase.execute(followerId).toUser();
        User followingUser = getUserByIdUseCase.execute(followingId).toUser();
        followerPK.setFollowerUser(followerUser);
        followerPK.setFollowingUser(followingUser);
        followerRepository.deleteFollowerById(followerPK);
    }

}
