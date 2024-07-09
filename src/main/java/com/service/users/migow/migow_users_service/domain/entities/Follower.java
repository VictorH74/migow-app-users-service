package com.service.users.migow.migow_users_service.domain.entities;

import java.time.Instant;
import java.util.Objects;

import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_follower")
public class Follower {
    @EmbeddedId
    private FollowerPK id;
    private Instant createdAt;

    public Follower() {
        this.createdAt = Instant.now();
    }

    public FollowerPK getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setId(FollowerPK id) {
        this.id = id;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
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
        Follower other = (Follower) obj;
        return Objects.equals(id, other.id);
    }

}
