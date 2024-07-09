package com.service.users.migow.migow_users_service.domain.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_notifications_settings")
public class NotificationSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    private User owner;

    private Boolean whenFollowersPostSomething;
    private Boolean whenFollowersCommentSomethig;
    private Boolean whenFollowersReactSomething;
    private Boolean whenFollowersReplaySomething;
    private Boolean whenFollowersMentionMe;

    public NotificationSettings() {
    }

    public NotificationSettings(Long id, User owner, Boolean whenFollowersPostSomething,
            Boolean whenFollowersCommentSomethig, Boolean whenFollowersReactSomething,
            Boolean whenFollowersReplaySomething, Boolean whenFollowersMentionMe) {
        this.id = id;
        this.owner = owner;
        this.whenFollowersPostSomething = whenFollowersPostSomething;
        this.whenFollowersCommentSomethig = whenFollowersCommentSomethig;
        this.whenFollowersReactSomething = whenFollowersReactSomething;
        this.whenFollowersReplaySomething = whenFollowersReplaySomething;
        this.whenFollowersMentionMe = whenFollowersMentionMe;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Boolean getWhenFollowersPostSomething() {
        return whenFollowersPostSomething;
    }

    public Boolean getWhenFollowersCommentSomethig() {
        return whenFollowersCommentSomethig;
    }

    public Boolean getWhenFollowersReactSomething() {
        return whenFollowersReactSomething;
    }

    public Boolean getWhenFollowersReplaySomething() {
        return whenFollowersReplaySomething;
    }

    public Boolean getWhenFollowersMentionMe() {
        return whenFollowersMentionMe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setWhenFollowersPostSomething(Boolean whenFollowersPostSomething) {
        this.whenFollowersPostSomething = whenFollowersPostSomething;
    }

    public void setWhenFollowersCommentSomethig(Boolean whenFollowersCommentSomethig) {
        this.whenFollowersCommentSomethig = whenFollowersCommentSomethig;
    }

    public void setWhenFollowersReactSomething(Boolean whenFollowersReactSomething) {
        this.whenFollowersReactSomething = whenFollowersReactSomething;
    }

    public void setWhenFollowersReplaySomething(Boolean whenFollowersReplaySomething) {
        this.whenFollowersReplaySomething = whenFollowersReplaySomething;
    }

    public void setWhenFollowersMentionMe(Boolean whenFollowersMentionMe) {
        this.whenFollowersMentionMe = whenFollowersMentionMe;
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
        NotificationSettings other = (NotificationSettings) obj;
        return Objects.equals(id, other.id);
    }
}
