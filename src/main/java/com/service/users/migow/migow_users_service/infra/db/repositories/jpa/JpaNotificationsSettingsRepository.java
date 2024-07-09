package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface JpaNotificationsSettingsRepository extends JpaRepository<NotificationSettings, Long> {
    public Optional<NotificationSettings> findByOwner(User user);
}
