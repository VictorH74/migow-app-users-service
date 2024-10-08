package com.service.users.migow.migow_users_service.application.usecases.notification_settings;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.NotificationSettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings.CreateNotificationsSettingsUseCase;

@Component
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
