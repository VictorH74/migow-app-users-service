package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface JpaPrivacySettingsRepository extends JpaRepository<PrivacySettings, Long> {
    public Optional<PrivacySettings> findByOwner(User user);

}
