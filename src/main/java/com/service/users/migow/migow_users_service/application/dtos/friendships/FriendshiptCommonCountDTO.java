package com.service.users.migow.migow_users_service.application.dtos.friendships;

import java.io.Serializable;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FriendshiptCommonCountDTO implements Serializable {
    private final Long count;
    private final SimpleUserDTO[] firstsTwoFriends;
}
