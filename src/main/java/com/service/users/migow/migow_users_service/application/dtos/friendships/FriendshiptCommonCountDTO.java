package com.service.users.migow.migow_users_service.application.dtos.friendships;

import java.io.Serializable;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;

public class FriendshiptCommonCountDTO implements Serializable {
    private final Long count;
    private final SimpleUserDTO[] firstsTwoFriends;

    public FriendshiptCommonCountDTO(Long count, SimpleUserDTO[] firstsTwoFriends) {
        this.count = count;
        this.firstsTwoFriends = firstsTwoFriends;
    }

    public Long getCount() {
        return count;
    }

    public SimpleUserDTO[] getFirstsTwoFriends() {
        return firstsTwoFriends;
    }

}
