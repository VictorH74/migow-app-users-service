package com.service.users.migow.migow_users_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllDetailedUserFollowerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.infra.http.dtos.FollowerUserDTO;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public class GetAllDetailedUserFollower implements GetAllDetailedUserFollowerUseCase {

    private final GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase;
    private final GetIsFollowerStatusUseCase getIsFollowerStatusUseCase;

    public GetAllDetailedUserFollower(GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase,
            GetIsFollowerStatusUseCase getIsFollowerStatusUseCase) {
        this.getAllUserByUsernamePrefixUseCase = getAllUserByUsernamePrefixUseCase;
        this.getIsFollowerStatusUseCase = getIsFollowerStatusUseCase;
    }

    @Override
    public Page<FollowerUserDTO> execute(String usernamePrefix, UUID followingId, Pageable pageable) {
        Page<SimpleUserDTO> users = getAllUserByUsernamePrefixUseCase.execute(usernamePrefix, pageable);

        return users.map(simpleUserDTO -> {
            boolean isFollower = getIsFollowerStatusUseCase.execute(simpleUserDTO.getId(), followingId);
            return new FollowerUserDTO(simpleUserDTO.toUser(), isFollower);
        });

    }

}
