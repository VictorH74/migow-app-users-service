package com.service.users.migow.migow_users_service.application.usecases.account_preference_settings;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.account_preference_settings.AccountPreferenceSettingsNotFoundException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.AccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings.GetAccountPreferenceSettingsByOwnerUseCase;

@Component
public class GetAccountPreferenceSettingsByOwner implements GetAccountPreferenceSettingsByOwnerUseCase {

    private final AccountPreferenceSettingsRepository accountPreferenceSettingsRepository;

    public GetAccountPreferenceSettingsByOwner(
            AccountPreferenceSettingsRepository accountPreferenceSettingsRepository) {
        this.accountPreferenceSettingsRepository = accountPreferenceSettingsRepository;
    }

    @Override
    public AccountPreferenceSettings execute(User user) {
        return accountPreferenceSettingsRepository.getAccountPreferenceSettingsByOwner(user)
                .orElseThrow(() -> new AccountPreferenceSettingsNotFoundException());
    }

}
