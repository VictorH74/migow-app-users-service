package com.service.users.migow.migow_users_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "db_user")
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
    @OneToMany(mappedBy = "id.followedUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Follower> followers;

    public User() {
        this.createdAt = Instant.now();
    }

    public User(UUID id, String username, String password, String name, @Email String email,
            @URL String profileImageUrl,
            @URL String bgImageUrl, Instant createdAt, Set<Follower> followers) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.bgImageUrl = bgImageUrl;
        this.createdAt = createdAt;
        this.followers = followers;
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

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getBgImageUrl() {
        return bgImageUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Set<Follower> getFollowers() {
        return followers;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void setBgImageUrl(String bgImageUrl) {
        this.bgImageUrl = bgImageUrl;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setFollowers(Set<Follower> followers) {
        this.followers = followers;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + "]";
    }

}
