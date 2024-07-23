package com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.dtos.account_preference_settings.SimpleAccountPreferenceSettingsDTO;

public interface GetAccountPreferenceSettingsByOwnerUseCase {
    SimpleAccountPreferenceSettingsDTO execute(UUID userId);
}
