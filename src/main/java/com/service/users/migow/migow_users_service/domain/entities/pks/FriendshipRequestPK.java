package com.service.users.migow.migow_users_service.domain.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.users.migow.migow_users_service.domain.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FriendshipRequestPK implements Serializable {
    @ManyToOne
    private User owner;
    @ManyToOne
    private User target;

    @Override
    public int hashCode() {
        return Objects.hash(owner, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        FriendshipRequestPK other = (FriendshipRequestPK) obj;
        return Objects.equals(owner, other.owner) && Objects.equals(target, other.target);
    }
}
