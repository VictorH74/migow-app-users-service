package com.service.users.migow.migow_users_service.application.dtos.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.User;

/**
 * return SimpleUserDTO with 'friendshipStatus' property
 */
public class SimpleUserWithFriendshipStatusDTO extends SimpleUserDTO {
    public SimpleUserWithFriendshipStatusDTO(User user, int friendshipStatus) {
        super(user);
        this.friendshipStatus = friendshipStatus;
    }

    private int friendshipStatus;

    public int getFriendshipStatus() {
        return friendshipStatus;
    }

    @Override
    public UUID getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getProfileImageUrl() {
        return super.getProfileImageUrl();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    public void setFriendshipStatus(int friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setProfileImageUrl(String profileImageUrl) {
        super.setProfileImageUrl(profileImageUrl);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

}
