package com.service.users.migow.migow_users_service.application.usecases.privacy_settings;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.privacy_settings.PrivacySettingsNotFoundException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.PrivacySettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings.GetPrivacySettingsByOwnerUseCase;

@Component
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
