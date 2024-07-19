package com.service.users.migow.migow_users_service.application.dtos.users;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.User;

public class ProfileUserDTO implements Serializable {
    private UUID id;
    private String username;
    private String name;
    private String profileImageUrl;
    private String bgImageUrl;
    private Instant createdAt;

    public ProfileUserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.profileImageUrl = user.getProfileImageUrl();
        this.bgImageUrl = user.getBgImageUrl();
        this.createdAt = user.getCreatedAt();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getBgImageUrl() {
        return bgImageUrl;
    }

    public void setBgImageUrl(String bgImageUrl) {
        this.bgImageUrl = bgImageUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
