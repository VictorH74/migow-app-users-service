package com.service.users.migow.migow_users_service.infra.http.dtos;

public class FollowedDTO {
    private boolean followed;

    public FollowedDTO(boolean followed) {
        this.followed = followed;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

}
