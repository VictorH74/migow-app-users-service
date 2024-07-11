package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetCommonFollowerCountUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetFullFollowersByFollowedIdUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.Follower;

@Component
public class GetCommonFollowerCount implements GetCommonFollowerCountUseCase {

    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetFullFollowersByFollowedIdUseCase getFullFollowersByFollowedIdUseCase;
    private final GetIsFollowerStatusUseCase getIsFollowerStatusUseCase;

    public GetCommonFollowerCount(GetUserByIdUseCase getUserByIdUseCase,
            GetFullFollowersByFollowedIdUseCase getFullFollowersByFollowedIdUseCase,
            GetIsFollowerStatusUseCase getIsFollowerStatusUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getFullFollowersByFollowedIdUseCase = getFullFollowersByFollowedIdUseCase;
        this.getIsFollowerStatusUseCase = getIsFollowerStatusUseCase;
    }

    @Override
    public Long execute(UUID userId, UUID targetUser) {
        getUserByIdUseCase.execute(userId);
        List<Follower> followers = getFullFollowersByFollowedIdUseCase.execute(userId);

        return followers.stream()
                .filter(follower -> getIsFollowerStatusUseCase.execute(follower.getId().getFollowerUser().getId(),
                        targetUser))
                .count();
    }

}
