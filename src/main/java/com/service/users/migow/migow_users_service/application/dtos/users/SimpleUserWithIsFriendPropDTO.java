package com.service.users.migow.migow_users_service.application.dtos.users;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.User;

/**
 * return SimpleUserDTO with 'isFriend' property
 */
public class SimpleUserWithIsFriendPropDTO extends SimpleUserDTO {
    public SimpleUserWithIsFriendPropDTO(User user, boolean isFriend) {
        super(user);
        this.isFriend = isFriend;
    }

    private boolean isFriend;

    public boolean getIsFriend() {
        return isFriend;
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

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
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
