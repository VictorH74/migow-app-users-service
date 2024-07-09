package com.service.users.migow.migow_users_service.application.usecases.privacy_settings;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.PrivacySettingsRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings.GetPrivacySettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.http.handlers.PrivacySettingsNotFoundException;

public class GetPrivacySettingsByOwner implements GetPrivacySettingsByOwnerUseCase {

    private final PrivacySettingsRepository privacySettingsRepository;

    public GetPrivacySettingsByOwner(PrivacySettingsRepository privacySettingsRepository) {
        this.privacySettingsRepository = privacySettingsRepository;
    }

    @Override
    public PrivacySettings execute(User user) {
        return privacySettingsRepository.getPrivacySettingsByOwner(user)
                .orElseThrow(() -> new PrivacySettingsNotFoundException());
    }

}
