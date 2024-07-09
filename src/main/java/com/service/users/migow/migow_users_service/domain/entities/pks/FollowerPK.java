package com.service.users.migow.migow_users_service.domain.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.users.migow.migow_users_service.domain.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class FollowerPK implements Serializable {
    @ManyToOne
    private User followerUser;
    @ManyToOne
    private User followingUser;

    public User getFollowerUser() {
        return followerUser;
    }

    public User getFollowingUser() {
        return followingUser;
    }

    public void setFollowerUser(User followerUser) {
        this.followerUser = followerUser;
    }

    public void setFollowingUser(User followingUser) {
        this.followingUser = followingUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerUser, followingUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        FollowerPK other = (FollowerPK) obj;
        return Objects.equals(followerUser, other.followerUser) && Objects.equals(followingUser, other.followingUser);
    }
}
