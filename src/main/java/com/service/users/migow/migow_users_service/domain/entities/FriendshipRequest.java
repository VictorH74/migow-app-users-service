package com.service.users.migow.migow_users_service.domain.entities;

import java.time.Instant;

import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "db_friendship_request")
@Getter
@Setter
@AllArgsConstructor
public class FriendshipRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    private FriendshipRequestPK id;
    private Instant createdAt;

    public FriendshipRequest() {
        createdAt = Instant.now();
    }
}
