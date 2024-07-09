package com.service.users.migow.migow_users_service.domain.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_privacy_settings")
public class PrivacySettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    private User owner;
    private Integer imageProfileVisibility;
    private Integer nameVisibility;
    private Integer bioVisibility;
    private Integer followersVisibility;
    private Integer activityVisibility;
    private Integer onlineStatusVisibility;
    private Integer messageReadConfirmationVisibility;

    public PrivacySettings() {
    }

    public PrivacySettings(Long id, User owner, Integer imageProfileVisibility, Integer nameVisibility,
            Integer bioVisibility, Integer followersVisibility, Integer activityVisibility,
            Integer onlineStatusVisibility, Integer messageReadConfirmationVisibility) {
        this.id = id;
        this.owner = owner;
        this.imageProfileVisibility = imageProfileVisibility;
        this.nameVisibility = nameVisibility;
        this.bioVisibility = bioVisibility;
        this.followersVisibility = followersVisibility;
        this.activityVisibility = activityVisibility;
        this.onlineStatusVisibility = onlineStatusVisibility;
        this.messageReadConfirmationVisibility = messageReadConfirmationVisibility;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Integer getImageProfileVisibility() {
        return imageProfileVisibility;
    }

    public Integer getNameVisibility() {
        return nameVisibility;
    }

    public Integer getBioVisibility() {
        return bioVisibility;
    }

    public Integer getFollowersVisibility() {
        return followersVisibility;
    }

    public Integer getActivityVisibility() {
        return activityVisibility;
    }

    public Integer getOnlineStatusVisibility() {
        return onlineStatusVisibility;
    }

    public Integer getMessageReadConfirmationVisibility() {
        return messageReadConfirmationVisibility;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setImageProfileVisibility(Integer imageProfileVisibility) {
        this.imageProfileVisibility = imageProfileVisibility;
    }

    public void setNameVisibility(Integer nameVisibility) {
        this.nameVisibility = nameVisibility;
    }

    public void setBioVisibility(Integer bioVisibility) {
        this.bioVisibility = bioVisibility;
    }

    public void setFollowersVisibility(Integer followersVisibility) {
        this.followersVisibility = followersVisibility;
    }

    public void setActivityVisibility(Integer activityVisibility) {
        this.activityVisibility = activityVisibility;
    }

    public void setOnlineStatusVisibility(Integer onlineStatusVisibility) {
        this.onlineStatusVisibility = onlineStatusVisibility;
    }

    public void setMessageReadConfirmationVisibility(Integer messageReadConfirmationVisibility) {
        this.messageReadConfirmationVisibility = messageReadConfirmationVisibility;
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
        PrivacySettings other = (PrivacySettings) obj;
        return Objects.equals(id, other.id);
    }

}
