package com.service.users.migow.migow_users_service.application.usecases.privacy_settings;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.PrivacySettingsRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings.CreatePrivacySettingsUseCase;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;

public class CreatePrivacySettings implements CreatePrivacySettingsUseCase {

    private final PrivacySettingsRepository privacySettingsRepository;

    public CreatePrivacySettings(PrivacySettingsRepository privacySettingsRepository) {
        this.privacySettingsRepository = privacySettingsRepository;
    }

    @Override
    public PrivacySettings execute(PrivacySettings obj) {
        return privacySettingsRepository.createPrivacySettings(obj);
    }

}
