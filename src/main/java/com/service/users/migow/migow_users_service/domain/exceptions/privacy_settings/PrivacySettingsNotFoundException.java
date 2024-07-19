package com.service.users.migow.migow_users_service.domain.exceptions.privacy_settings;

public class PrivacySettingsNotFoundException extends RuntimeException {
    public PrivacySettingsNotFoundException() {
        super("Privacy settings not found");
    }
}
