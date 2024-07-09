package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.account_preference_settings.GetAccountPreferenceSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.notification_settings.GetNotificationsSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings.GetPrivacySettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.dtos.ProfileSettingsDTO;

@RestController
@RequestMapping("settings/{userId}")
public class SettingsController {

    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetAccountPreferenceSettingsByOwnerUseCase gapsboUseCase;
    private final GetPrivacySettingsByOwnerUseCase gpsboUseCase;
    private final GetNotificationsSettingsByOwnerUseCase gnsboUseCase;

    public SettingsController(GetUserByIdUseCase getUserByIdUseCase,
            GetAccountPreferenceSettingsByOwnerUseCase gapsboUseCase, GetPrivacySettingsByOwnerUseCase gpsboUseCase,
            GetNotificationsSettingsByOwnerUseCase gnsboUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.gapsboUseCase = gapsboUseCase;
        this.gpsboUseCase = gpsboUseCase;
        this.gnsboUseCase = gnsboUseCase;
    }

    @GetMapping("/")
    public ProfileSettingsDTO getUserProfileSettings(@RequestParam UUID userId) {
        User user = getUserByIdUseCase.execute(userId).toUser();
        AccountPreferenceSettings accountPreferenceSettings = gapsboUseCase.execute(user);
        PrivacySettings privacySettings = gpsboUseCase.execute(user);
        NotificationSettings notificationsSettings = gnsboUseCase.execute(user);

        return new ProfileSettingsDTO(
                accountPreferenceSettings,
                privacySettings,
                notificationsSettings);

    }

    @GetMapping("/account-preference-settings")
    public AccountPreferenceSettings getUserAccountPreferenceSettings(@RequestParam UUID userId) {
        User user = getUserByIdUseCase.execute(userId).toUser();
        return gapsboUseCase.execute(user);
    }

    @GetMapping("/privacy-settings")
    public PrivacySettings getUserPrivacySettings(@RequestParam UUID userId) {
        User user = getUserByIdUseCase.execute(userId).toUser();
        return gpsboUseCase.execute(user);
    }

    @GetMapping("/notifications-settings")
    public NotificationSettings getUserNotificationsSettings(@RequestParam UUID userId) {
        User user = getUserByIdUseCase.execute(userId).toUser();
        return gnsboUseCase.execute(user);
    }

}
