package com.service.users.migow.migow_users_service.main.factories.usecases.notification_settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.notification_settings.GetNotificationsSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.application.usecases.notification_settings.GetNotificationsSettingsByOwner;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.NotificationSettingsRepositoryImpl;

@Configuration
public class GetNotificationsSettingsByOwnerFactory {
    @Bean
    public GetNotificationsSettingsByOwnerUseCase GetNotificationsSettingsByOwnerUseCase(
            NotificationSettingsRepositoryImpl notificationSettingsRepositoryImpl) {
        return new GetNotificationsSettingsByOwner(notificationSettingsRepositoryImpl);
    }
}
