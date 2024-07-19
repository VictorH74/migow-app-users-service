package com.service.users.migow.migow_users_service.application.dtos.users;

import java.io.Serializable;
import java.util.UUID;

import com.service.users.migow.migow_users_service.domain.entities.User;

/**
 * @return { id, username, name, profileImageUrl }
 */
public class SimpleUserDTO implements Serializable {
    private UUID id;
    private String username;
    private String name;
    private String profileImageUrl;

    public SimpleUserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.profileImageUrl = user.getProfileImageUrl();
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public User toUser() {
        User user = new User();

        user.setId(this.id);
        user.setUsername(this.username);
        user.setName(this.name);
        user.setProfileImageUrl(this.profileImageUrl);

        return user;
    }
}
