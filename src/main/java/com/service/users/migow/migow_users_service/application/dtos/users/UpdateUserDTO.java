package com.service.users.migow.migow_users_service.application.dtos.users;

public class UpdateUserDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String profileImageUrl;
    private String bgImageUrl;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String username, String password, String name, String email, String profileImageUrl,
            String bgImageUrl) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.bgImageUrl = bgImageUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getBgImageUrl() {
        return bgImageUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void setBgImageUrl(String bgImageUrl) {
        this.bgImageUrl = bgImageUrl;
    }

}
