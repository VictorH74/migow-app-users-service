package com.service.users.migow.migow_users_service.infra.http.dtos;

import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.User;

/**
 * return SimpleUserDTO with 'isFollowed' property
 */
public class FollowerUserDTO extends SimpleUserDTO {
    public FollowerUserDTO(User user, boolean isFollowed) {
        super(user);
        this.isFollowed = isFollowed;
    }

    private boolean isFollowed;

    public boolean isIsFollowed() {
        return isFollowed;
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

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
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
