package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.users.DetailedUserDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetAllDetailedByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.infra.helpers.CustomPage;

@Component
public class GetAllDetailedUserByUsernamePrefix implements GetAllDetailedByUsernamePrefixUseCase {

    private final GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase;
    private final GetFriendshipStatusUseCase getFriendshipStatusUseCase;

    public GetAllDetailedUserByUsernamePrefix(GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase,
            GetFriendshipStatusUseCase getFriendshipStatusUseCase) {
        this.getAllUserByUsernamePrefixUseCase = getAllUserByUsernamePrefixUseCase;
        this.getFriendshipStatusUseCase = getFriendshipStatusUseCase;
    }

    @Override
    public CustomPage<DetailedUserDTO> execute(String usernamePrefix, UUID userId, Pageable pageable) {
        CustomPage<SimpleUserDTO> users = getAllUserByUsernamePrefixUseCase.execute(usernamePrefix, pageable);

        return users.map(simpleUserDTO -> {
            boolean isFollower = getFriendshipStatusUseCase.execute(simpleUserDTO.getId(), userId);
            return new DetailedUserDTO(simpleUserDTO.toUser(), isFollower);
        });

    }

}
