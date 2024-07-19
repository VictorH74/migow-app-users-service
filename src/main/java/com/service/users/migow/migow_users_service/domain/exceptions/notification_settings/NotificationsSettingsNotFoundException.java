package com.service.users.migow.migow_users_service.domain.exceptions.notification_settings;

public class NotificationsSettingsNotFoundException extends RuntimeException {
    public NotificationsSettingsNotFoundException() {
        super("Notifications settings not found");
    }

}
