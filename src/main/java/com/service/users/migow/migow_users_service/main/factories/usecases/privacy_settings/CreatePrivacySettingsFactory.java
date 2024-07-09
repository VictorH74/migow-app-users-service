package com.service.users.migow.migow_users_service.main.factories.usecases.privacy_settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings.CreatePrivacySettingsUseCase;
import com.service.users.migow.migow_users_service.application.usecases.privacy_settings.CreatePrivacySettings;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.PrivacySettingsRepositoryImpl;

@Configuration
public class CreatePrivacySettingsFactory {
    @Bean
    public CreatePrivacySettingsUseCase createPrivacySettingsUseCase(
            PrivacySettingsRepositoryImpl privacySettingsRepositoryImpl) {
        return new CreatePrivacySettings(privacySettingsRepositoryImpl);
    }
}
