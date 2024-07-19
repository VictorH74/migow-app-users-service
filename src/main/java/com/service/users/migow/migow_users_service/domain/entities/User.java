package com.service.users.migow.migow_users_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "db_user")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {
    @Id
    // @GeneratedValue(generator = "UUID")
    // @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
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

    // @OneToMany(mappedBy = "id.friendUser", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<Friendship> friendships;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    public User() {
        this.createdAt = Instant.now();
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
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

}
