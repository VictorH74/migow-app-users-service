package com.service.users.migow.migow_users_service.infra.http.handlers;

public class PrivacySettingsNotFoundException extends RuntimeException {
    public PrivacySettingsNotFoundException() {
        super("Privacy settings not found");
    }
}
