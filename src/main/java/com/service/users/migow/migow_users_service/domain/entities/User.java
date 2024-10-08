package com.service.users.migow.migow_users_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "db_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username", name = "UK_USERNAME"),
    @UniqueConstraint(columnNames = "email", name = "UK_EMAIL")
})
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    private UUID id;
    @Column(nullable = false, unique = true, length = 25)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, unique = true, length = 50)
    @Email
    private String email;
    @URL
    private String profileImageUrl;
    @URL
    private String bgImageUrl;
    private Instant createdAt;

    private Set<String> roles;

    public User() {
        this.createdAt = Instant.now();
        this.roles = Set.of("USER");
    }

    public User(String username, String password, String name, @Email String email, @URL String profileImageUrl,
            @URL String bgImageUrl) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.bgImageUrl = bgImageUrl;
    }

    public User(UUID id, String username, String password, String name, @Email String email,
            @URL String profileImageUrl,
            @URL String bgImageUrl) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.bgImageUrl = bgImageUrl;
        this.roles = Set.of("USER");
        this.createdAt = Instant.now();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

}
