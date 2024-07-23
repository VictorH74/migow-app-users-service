package com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.dtos.notification_settings.SimpleNotificationSettingsDTO;

public interface GetNotificationsSettingsByOwnerUseCase {
    SimpleNotificationSettingsDTO execute(UUID userId);
}
