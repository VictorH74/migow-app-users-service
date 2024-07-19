package com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface GetNotificationsSettingsByOwnerUseCase {
    NotificationSettings execute(User user);
}
