package com.service.users.migow.migow_users_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.domain.entities.User;

public interface UserRepository {
    List<User> createManyUser(List<User> objs);

    User createUpdateUser(User obj);

    Page<User> getAllUserByUsernamePrefix(String usernamePrefix, Pageable pageable);

    Optional<User> getUserById(UUID id);

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserByUsername(String username);

    void deleteUserById(UUID id);
}
