package com.service.users.migow.migow_users_service.application.usecases.account_preference_settings;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.account_preference_settings.SimpleAccountPreferenceSettingsDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.exceptions.account_preference_settings.AccountPreferenceSettingsNotFoundException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.AccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings.GetAccountPreferenceSettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAccountPreferenceSettingsByOwner implements GetAccountPreferenceSettingsByOwnerUseCase {

    private final AccountPreferenceSettingsRepository accountPreferenceSettingsRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public SimpleAccountPreferenceSettingsDTO execute(UUID userId) {
        SimpleUserDTO user = getUserByIdUseCase.execute(userId);
        AccountPreferenceSettings accountPreferenceSettings = accountPreferenceSettingsRepository
                .getAccountPreferenceSettingsByOwner(user.toUser())
                .orElseThrow(() -> new AccountPreferenceSettingsNotFoundException());
        return new SimpleAccountPreferenceSettingsDTO(accountPreferenceSettings);
    }

}
