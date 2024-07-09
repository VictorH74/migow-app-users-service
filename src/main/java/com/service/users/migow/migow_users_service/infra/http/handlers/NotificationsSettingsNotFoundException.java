package com.service.users.migow.migow_users_service.infra.http.handlers;

public class NotificationsSettingsNotFoundException extends RuntimeException {
    public NotificationsSettingsNotFoundException() {
        super("Notifications settings not found");
    }

}
