package com.service.users.migow.migow_users_service.application.usecases.account_preference_settings;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.AccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.account_preference_settings.CreateAccountPreferenceSettingsUseCase;
import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;

public class CreateAccountPreferenceSettings implements CreateAccountPreferenceSettingsUseCase {

    private final AccountPreferenceSettingsRepository accountPreferenceSettingsRepository;

    public CreateAccountPreferenceSettings(AccountPreferenceSettingsRepository accountPreferenceSettingsRepository) {
        this.accountPreferenceSettingsRepository = accountPreferenceSettingsRepository;
    }

    @Override
    public AccountPreferenceSettings execute(AccountPreferenceSettings obj) {
        return accountPreferenceSettingsRepository.createAccountPreferenceSettings(obj);
    }

}
