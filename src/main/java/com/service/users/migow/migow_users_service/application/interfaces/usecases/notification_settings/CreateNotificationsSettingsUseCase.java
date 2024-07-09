package com.service.users.migow.migow_users_service.application.interfaces.usecases.notification_settings;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;

public interface CreateNotificationsSettingsUseCase {
    NotificationSettings execute(NotificationSettings obj);
}
