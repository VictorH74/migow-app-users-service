package com.service.users.migow.migow_users_service.application.dtos.account_preference_settings;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;

import lombok.Getter;

@Getter
public class SimpleAccountPreferenceSettingsDTO {
    private final Long id;
    private final Integer theme;
    private final Integer onlineUsersLimit;
    private final Boolean soundEffects;

    public SimpleAccountPreferenceSettingsDTO(AccountPreferenceSettings apSettings) {
        this.id = apSettings.getId();
        this.theme = apSettings.getTheme();
        this.onlineUsersLimit = apSettings.getOnlineUsersLimit();
        this.soundEffects = apSettings.getSoundEffects();
    }
}
