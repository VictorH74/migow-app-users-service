package com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;

public interface CreateNotificationsSettingsUseCase {
    NotificationSettings execute(NotificationSettings obj);
}
