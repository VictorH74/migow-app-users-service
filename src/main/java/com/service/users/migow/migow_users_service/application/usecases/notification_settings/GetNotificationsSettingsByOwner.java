package com.service.users.migow.migow_users_service.application.usecases.notification_settings;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.notification_settings.NotificationsSettingsNotFoundException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.NotificationSettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings.GetNotificationsSettingsByOwnerUseCase;

@Component
public class GetNotificationsSettingsByOwner implements GetNotificationsSettingsByOwnerUseCase {

    private final NotificationSettingsRepository notificationSettingsRepository;

    public GetNotificationsSettingsByOwner(NotificationSettingsRepository notificationSettingsRepository) {
        this.notificationSettingsRepository = notificationSettingsRepository;
    }

    @Override
    public NotificationSettings execute(User user) {
        return notificationSettingsRepository.getNotificationSettingsByOwner(user)
                .orElseThrow(() -> new NotificationsSettingsNotFoundException());
    }

}
