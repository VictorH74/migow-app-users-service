package com.service.users.migow.migow_users_service.domain.entities;

import java.time.Instant;
import java.util.Objects;

import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_friendship")
public class Friendship {
    @EmbeddedId
    private FriendshipPK id;
    private Instant createdAt;

    public Friendship() {
        this.createdAt = Instant.now();
    }

    public FriendshipPK getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setId(FriendshipPK id) {
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
        Friendship other = (Friendship) obj;
        return Objects.equals(id, other.id);
    }

}
