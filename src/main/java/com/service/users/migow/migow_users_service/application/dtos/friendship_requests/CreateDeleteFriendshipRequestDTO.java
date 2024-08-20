package com.service.users.migow.migow_users_service.application.dtos.friendship_requests;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateDeleteFriendshipRequestDTO {
    private final UUID ownerId;
    private final UUID targetId;
}
