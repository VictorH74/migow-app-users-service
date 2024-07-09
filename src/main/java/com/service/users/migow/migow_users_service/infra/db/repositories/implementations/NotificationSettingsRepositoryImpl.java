package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.NotificationSettingsRepository;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaNotificationsSettingsRepository;

@Repository
public class NotificationSettingsRepositoryImpl implements NotificationSettingsRepository {
    private final JpaNotificationsSettingsRepository jpaNotificationsSettingsRepository;

    public NotificationSettingsRepositoryImpl(JpaNotificationsSettingsRepository jpaNotificationsSettingsRepository) {
        this.jpaNotificationsSettingsRepository = jpaNotificationsSettingsRepository;
    }

    @Override
    public NotificationSettings createNotificationSettings(NotificationSettings obj) {
        return jpaNotificationsSettingsRepository.save(obj);
    }

    @Override
    public Optional<NotificationSettings> getNotificationSettingsByOwner(User user) {
        return jpaNotificationsSettingsRepository.findByOwner(user);
    }

}
