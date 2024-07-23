package com.service.users.migow.migow_users_service.application.usecases.notification_settings;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.notification_settings.SimpleNotificationSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.exceptions.notification_settings.NotificationsSettingsNotFoundException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.NotificationSettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings.GetNotificationsSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetNotificationsSettingsByOwner implements GetNotificationsSettingsByOwnerUseCase {

    private final NotificationSettingsRepository notificationSettingsRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public SimpleNotificationSettingsDTO execute(UUID userId) {
        SimpleUserDTO user = getUserByIdUseCase.execute(userId);

        NotificationSettings notificationSettings = notificationSettingsRepository
                .getNotificationSettingsByOwner(user.toUser())
                .orElseThrow(() -> new NotificationsSettingsNotFoundException());
        return new SimpleNotificationSettingsDTO(notificationSettings);
    }

}
