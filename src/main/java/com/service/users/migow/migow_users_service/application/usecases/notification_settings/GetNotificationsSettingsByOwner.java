package com.service.users.migow.migow_users_service.application.usecases.notification_settings;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.NotificationSettingsRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.notification_settings.GetNotificationsSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.handlers.NotificationsSettingsNotFoundException;

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
