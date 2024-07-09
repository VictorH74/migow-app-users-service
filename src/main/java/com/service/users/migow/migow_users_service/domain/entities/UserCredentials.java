package com.service.users.migow.migow_users_service.domain.entities;

import java.io.Serializable;

public class UserCredentials implements Serializable {
    private String login; // email or users
    private String password;

    public UserCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
