package com.service.users.migow.migow_users_service.application.dtos.friendships;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateDeleteFriendshipDTO {
    private final UUID userId;
    private final UUID friendId;
}
