package com.service.users.migow.migow_users_service.infra.http.handlers;

public class AccountPreferenceSettingsNotFoundException extends RuntimeException {
    public AccountPreferenceSettingsNotFoundException() {
        super("Account preference settings not found!");
    }

}
