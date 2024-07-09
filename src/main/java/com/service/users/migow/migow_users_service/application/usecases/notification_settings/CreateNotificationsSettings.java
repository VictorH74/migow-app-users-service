package com.service.users.migow.migow_users_service.application.usecases.notification_settings;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.NotificationSettingsRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.notification_settings.CreateNotificationsSettingsUseCase;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;

public class CreateNotificationsSettings implements CreateNotificationsSettingsUseCase {

    private final NotificationSettingsRepository notificationSettingsRepository;

    public CreateNotificationsSettings(NotificationSettingsRepository notificationSettingsRepository) {
        this.notificationSettingsRepository = notificationSettingsRepository;
    }

    @Override
    public NotificationSettings execute(NotificationSettings obj) {
        return notificationSettingsRepository.createNotificationSettings(obj);
    }

}
