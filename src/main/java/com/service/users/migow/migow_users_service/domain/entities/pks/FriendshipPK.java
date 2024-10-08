package com.service.users.migow.migow_users_service.domain.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.users.migow.migow_users_service.domain.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendshipPK implements Serializable {

    @ManyToOne
    private User user;
    @ManyToOne
    private User friendUser;

    @Override
    public int hashCode() {
        return Objects.hash(user, friendUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FriendshipPK other = (FriendshipPK) obj;
        return Objects.equals(user, other.user) && Objects.equals(friendUser, other.friendUser);
    }
}
