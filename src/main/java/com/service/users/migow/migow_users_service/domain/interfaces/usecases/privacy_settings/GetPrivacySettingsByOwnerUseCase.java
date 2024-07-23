package com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings;

import java.util.UUID;

import com.service.users.migow.migow_users_service.application.dtos.privacy_settings.SimplePrivacySettingsDTO;

public interface GetPrivacySettingsByOwnerUseCase {
    SimplePrivacySettingsDTO execute(UUID userId);
}
