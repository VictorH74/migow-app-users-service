package com.service.users.migow.migow_users_service.domain.exceptions.account_preference_settings;

public class AccountPreferenceSettingsNotFoundException extends RuntimeException {
    public AccountPreferenceSettingsNotFoundException() {
        super("Account preference settings not found!");
    }

}
