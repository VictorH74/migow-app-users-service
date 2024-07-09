package com.service.users.migow.migow_users_service.infra.http.dtos;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;

public class ProfileSettingsDTO {
    private AccountPreferenceSettings accountPreferenceSettings;
    private PrivacySettings privacySettings;
    private NotificationSettings notificationsSettings;

    public ProfileSettingsDTO() {
    }

    public ProfileSettingsDTO(AccountPreferenceSettings accountPreferenceSettings, PrivacySettings privacySettings,
            NotificationSettings notificationsSettings) {
        this.accountPreferenceSettings = accountPreferenceSettings;
        this.privacySettings = privacySettings;
        this.notificationsSettings = notificationsSettings;
    }

    public AccountPreferenceSettings getAccountPreferenceSettings() {
        return accountPreferenceSettings;
    }

    public PrivacySettings getPrivacySettings() {
        return privacySettings;
    }

    public NotificationSettings getNotificationsSettings() {
        return notificationsSettings;
    }

    public void setAccountPreferenceSettings(AccountPreferenceSettings accountPreferenceSettings) {
        this.accountPreferenceSettings = accountPreferenceSettings;
    }

    public void setPrivacySettings(PrivacySettings privacySettings) {
        this.privacySettings = privacySettings;
    }

    public void setNotificationsSettings(NotificationSettings notificationsSettings) {
        this.notificationsSettings = notificationsSettings;
    }
}
