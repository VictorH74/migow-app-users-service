package com.service.users.migow.migow_users_service.application.usecases.friendships;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshiptCommonCountDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.enums.FriendshipStatusEnum;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetCommonFriendshipCountUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFullUserFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class GetCommonFriendshipCount implements GetCommonFriendshipCountUseCase {

    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetFullUserFriendshipUseCase getFullFriendshipsByUserIdUseCase;
    private final GetFriendshipStatusUseCase getFriendshipStatusUseCase;

    public GetCommonFriendshipCount(GetUserByIdUseCase getUserByIdUseCase,
            GetFullUserFriendshipUseCase getFullFriendshipsByUserIdUseCase,
            GetFriendshipStatusUseCase getFriendshipStatusUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getFullFriendshipsByUserIdUseCase = getFullFriendshipsByUserIdUseCase;
        this.getFriendshipStatusUseCase = getFriendshipStatusUseCase;
    }

    @Override
    public FriendshiptCommonCountDTO execute(UUID userId, UUID targetUser) {
        getUserByIdUseCase.execute(userId);
        List<Friendship> friendships = getFullFriendshipsByUserIdUseCase.execute(userId);

        Long count = friendships.stream()
                .filter(friendship -> getFriendshipStatusUseCase.execute(friendship.getId().getUser().getId(),
                        targetUser).equals(FriendshipStatusEnum.IS_FRIEND))
                .count();

        SimpleUserDTO[] firstTwoFriends = {
                getSimpleUserFromFriendship(userId, friendships.get(0)),
                getSimpleUserFromFriendship(userId, friendships.get(1))
        };

        return new FriendshiptCommonCountDTO(count, firstTwoFriends);
    }

    private SimpleUserDTO getSimpleUserFromFriendship(UUID userId, Friendship f) {
        User user = f.getId().getUser();

        return new SimpleUserDTO(user.getId().equals(userId) ? f.getId().getFriendUser() : user);
    }

}
