package com.service.users.migow.migow_users_service.domain.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_account_preference_settings")
public class AccountPreferenceSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    private User owner;
    @Column(nullable = false, length = 1)
    private Integer theme;
    private Integer onlineUsersLimit;
    private Boolean soundEffects;

    public AccountPreferenceSettings() {
    }

    public AccountPreferenceSettings(Long id, User owner, Integer theme, Boolean soundEffects) {
        this.id = id;
        this.owner = owner;
        this.theme = theme;
        this.soundEffects = soundEffects;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Integer getTheme() {
        return theme;
    }

    public Boolean getSoundEffects() {
        return soundEffects;
    }

    public Integer getOnlineUsersLimit() {
        return onlineUsersLimit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public void setSoundEffects(Boolean soundEffects) {
        this.soundEffects = soundEffects;
    }

    public void setOnlineUsersLimit(Integer onlineUsersLimit) {
        this.onlineUsersLimit = onlineUsersLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccountPreferenceSettings other = (AccountPreferenceSettings) obj;
        return Objects.equals(id, other.id);
    }

}
