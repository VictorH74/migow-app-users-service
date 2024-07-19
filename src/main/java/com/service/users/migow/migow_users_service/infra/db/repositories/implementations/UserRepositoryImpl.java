package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaUserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public List<User> createManyUser(List<User> objs) {
        return jpaUserRepository.saveAll(objs);
        // return jpaUserRepository.saveAllAndFlush(objs);
    }

    @Override
    public User createUpdateUser(User obj) {
        return jpaUserRepository.save(obj);
    }

    @Override
    public void deleteUserById(UUID id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public Page<User> getAllUserByUsernamePrefix(String usernamePrefix, Pageable pageable) {
        return jpaUserRepository.findAllUserByUsernamePrefix(usernamePrefix, pageable);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return jpaUserRepository.findUserByLogin(login);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return jpaUserRepository.findByUsername(username);
    }

}
