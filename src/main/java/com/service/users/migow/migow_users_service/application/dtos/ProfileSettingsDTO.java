package com.service.users.migow.migow_users_service.application.dtos;

import com.service.users.migow.migow_users_service.application.dtos.account_preference_settings.SimpleAccountPreferenceSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.notification_settings.SimpleNotificationSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.privacy_settings.SimplePrivacySettingsDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProfileSettingsDTO {
    private final SimpleAccountPreferenceSettingsDTO accountPreferenceSettings;
    private final SimplePrivacySettingsDTO privacySettings;
    private final SimpleNotificationSettingsDTO notificationsSettings;
}
