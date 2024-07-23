package com.service.users.migow.migow_users_service.application.usecases.privacy_settings;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.privacy_settings.SimplePrivacySettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.exceptions.privacy_settings.PrivacySettingsNotFoundException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.PrivacySettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings.GetPrivacySettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetPrivacySettingsByOwner implements GetPrivacySettingsByOwnerUseCase {

    private final PrivacySettingsRepository privacySettingsRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public SimplePrivacySettingsDTO execute(UUID userId) {
        SimpleUserDTO user = getUserByIdUseCase.execute(userId);
        PrivacySettings privacySettings = privacySettingsRepository.getPrivacySettingsByOwner(user.toUser())
                .orElseThrow(() -> new PrivacySettingsNotFoundException());
        return new SimplePrivacySettingsDTO(privacySettings);
    }

}
