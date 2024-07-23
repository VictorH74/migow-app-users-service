package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.dtos.ProfileSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.account_preference_settings.SimpleAccountPreferenceSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.notification_settings.SimpleNotificationSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.privacy_settings.SimplePrivacySettingsDTO;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings.GetAccountPreferenceSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings.GetNotificationsSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings.GetPrivacySettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.infra.helpers.SecurityUtils;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("settings/{userId}")
@AllArgsConstructor
public class SettingsController {

    private final GetAccountPreferenceSettingsByOwnerUseCase gapsboUseCase;
    private final GetPrivacySettingsByOwnerUseCase gpsboUseCase;
    private final GetNotificationsSettingsByOwnerUseCase gnsboUseCase;

    @GetMapping
    public ProfileSettingsDTO getUserProfileSettings() {
        UUID userId = SecurityUtils.getAuthenticatedUserId();
        SimpleAccountPreferenceSettingsDTO accountPreferenceSettings = gapsboUseCase.execute(userId);
        SimplePrivacySettingsDTO privacySettings = gpsboUseCase.execute(userId);
        SimpleNotificationSettingsDTO notificationsSettings = gnsboUseCase.execute(userId);

        return new ProfileSettingsDTO(
                accountPreferenceSettings,
                privacySettings,
                notificationsSettings);
    }

    @GetMapping("/account-preference")
    public SimpleAccountPreferenceSettingsDTO getUserAccountPreferenceSettings() {
        UUID userId = SecurityUtils.getAuthenticatedUserId();
        return gapsboUseCase.execute(userId);
    }

    @GetMapping("/privacy")
    public SimplePrivacySettingsDTO getUserPrivacySettings() {
        UUID userId = SecurityUtils.getAuthenticatedUserId();
        return gpsboUseCase.execute(userId);
    }

    @GetMapping("/notification")
    public SimpleNotificationSettingsDTO getUserNotificationsSettings() {
        UUID userId = SecurityUtils.getAuthenticatedUserId();
        return gnsboUseCase.execute(userId);
    }

}
