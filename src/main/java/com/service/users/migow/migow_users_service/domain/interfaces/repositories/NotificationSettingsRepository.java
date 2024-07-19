package com.service.users.migow.migow_users_service.domain.interfaces.repositories;

import java.util.Optional;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface NotificationSettingsRepository {
    NotificationSettings createNotificationSettings(NotificationSettings obj);

    Optional<NotificationSettings> getNotificationSettingsByOwner(User user);
}
