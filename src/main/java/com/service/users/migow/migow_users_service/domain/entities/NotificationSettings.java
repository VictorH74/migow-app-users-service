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

    private Boolean whenFriendsPostSomething;
    private Boolean whenFriendsCommentSomethig;
    private Boolean whenFriendsReactSomething;
    private Boolean whenFriendsReplaySomething;
    private Boolean whenFriendsMentionMe;

    public NotificationSettings() {
    }

    public NotificationSettings(Long id, User owner, Boolean whenFriendsPostSomething,
            Boolean whenFriendsCommentSomethig, Boolean whenFriendsReactSomething,
            Boolean whenFriendsReplaySomething, Boolean whenFriendsMentionMe) {
        this.id = id;
        this.owner = owner;
        this.whenFriendsPostSomething = whenFriendsPostSomething;
        this.whenFriendsCommentSomethig = whenFriendsCommentSomethig;
        this.whenFriendsReactSomething = whenFriendsReactSomething;
        this.whenFriendsReplaySomething = whenFriendsReplaySomething;
        this.whenFriendsMentionMe = whenFriendsMentionMe;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Boolean getWhenFriendsPostSomething() {
        return whenFriendsPostSomething;
    }

    public Boolean getWhenFriendsCommentSomethig() {
        return whenFriendsCommentSomethig;
    }

    public Boolean getWhenFriendsReactSomething() {
        return whenFriendsReactSomething;
    }

    public Boolean getWhenFriendsReplaySomething() {
        return whenFriendsReplaySomething;
    }

    public Boolean getWhenFriendsMentionMe() {
        return whenFriendsMentionMe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setWhenFriendsPostSomething(Boolean whenFriendsPostSomething) {
        this.whenFriendsPostSomething = whenFriendsPostSomething;
    }

    public void setWhenFriendsCommentSomethig(Boolean whenFriendsCommentSomethig) {
        this.whenFriendsCommentSomethig = whenFriendsCommentSomethig;
    }

    public void setWhenFriendsReactSomething(Boolean whenFriendsReactSomething) {
        this.whenFriendsReactSomething = whenFriendsReactSomething;
    }

    public void setWhenFriendsReplaySomething(Boolean whenFriendsReplaySomething) {
        this.whenFriendsReplaySomething = whenFriendsReplaySomething;
    }

    public void setWhenFriendsMentionMe(Boolean whenFriendsMentionMe) {
        this.whenFriendsMentionMe = whenFriendsMentionMe;
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
