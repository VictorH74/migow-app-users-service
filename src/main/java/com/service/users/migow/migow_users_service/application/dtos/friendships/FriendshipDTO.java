package com.service.users.migow.migow_users_service.application.dtos.friendships;

public class FriendshipDTO {
    private boolean isFriend;

    public FriendshipDTO(boolean isFriend) {
        this.isFriend = isFriend;
    }

    public boolean getIsFriend() {
        return isFriend;
    }

    public void setFollowed(boolean isFriend) {
        this.isFriend = isFriend;
    }

}
