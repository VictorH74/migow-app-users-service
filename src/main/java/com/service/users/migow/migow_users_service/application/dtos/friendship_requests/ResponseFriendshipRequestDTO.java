package com.service.users.migow.migow_users_service.application.dtos.friendship_requests;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;

import lombok.Getter;

@Getter
public class ResponseFriendshipRequestDTO {
    private final SimpleUserDTO user;

    public ResponseFriendshipRequestDTO(User user) {
        this.user = new SimpleUserDTO(user);
    }
}
