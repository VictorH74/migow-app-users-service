package com.service.users.migow.migow_users_service.application.usecases.privacy_settings;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.PrivacySettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings.CreatePrivacySettingsUseCase;

@Component
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
