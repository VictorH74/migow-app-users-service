package com.service.users.migow.migow_users_service.application.usecases.account_preference_settings;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.AccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings.CreateAccountPreferenceSettingsUseCase;

@Component
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
