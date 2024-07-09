package com.service.users.migow.migow_users_service.main.factories.usecases.account_preference_settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.account_preference_settings.CreateAccountPreferenceSettingsUseCase;
import com.service.users.migow.migow_users_service.application.usecases.account_preference_settings.CreateAccountPreferenceSettings;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.AccountPreferenceSettingsRepositoryImpl;

@Configuration
public class CreateAccountPreferenceSettingsFactory {
    @Bean
    public CreateAccountPreferenceSettingsUseCase createAccountPreferenceSettingsUseCase(
            AccountPreferenceSettingsRepositoryImpl accountPreferenceSettingsRepositoryImpl) {
        return new CreateAccountPreferenceSettings(accountPreferenceSettingsRepositoryImpl);
    }
}
