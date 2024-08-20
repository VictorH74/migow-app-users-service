package com.service.users.migow.migow_users_service.application.dtos.friendships;

import com.service.users.migow.migow_users_service.domain.enums.FriendshipStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FriendshipStatusDTO {
    private FriendshipStatusEnum friendshipStatus;
}
