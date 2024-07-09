package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.users.migow.migow_users_service.domain.entities.User;


public interface JpaUserRepository extends JpaRepository<User, UUID> {
    public Optional<User> findByUsername(String username);

    @Query("SELECT user FROM User user WHERE user.email=:login OR user.username=:login")
    public Optional<User> getUserByLogin(String login);

    @Query("SELECT user FROM User user WHERE user.username LIKE CONCAT(:usernamePrefix, '%')")
    public Page<User> findUsersByUsernamePrefix(String usernamePrefix, Pageable pageable);

    /*
    @Query("SELECT new com.service.users.migow.migow_users_service.dto.SimpleUserDTO(user.username, user.email) FROM User user WHERE user.username LIKE :usernamePrefix%")
    public Page<SimpleUserDTO> findAllSimpleUsers(@Param("usernamePrefix") String usernamePrefix, Pageable pageable);
     */

}
