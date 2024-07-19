package com.service.users.migow.migow_users_service.application.dtos.friendships;

public class FriendshipCountDTO {
    private Long count;

    public FriendshipCountDTO(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
