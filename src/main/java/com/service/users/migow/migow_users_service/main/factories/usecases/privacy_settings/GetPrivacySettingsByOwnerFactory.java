package com.service.users.migow.migow_users_service.main.factories.usecases.privacy_settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings.GetPrivacySettingsByOwnerUseCase;
import com.service.users.migow.migow_users_service.application.usecases.privacy_settings.GetPrivacySettingsByOwner;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.PrivacySettingsRepositoryImpl;

@Configuration
public class GetPrivacySettingsByOwnerFactory {
    @Bean
    public GetPrivacySettingsByOwnerUseCase getPrivacySettingsByOwnerUseCase(
            PrivacySettingsRepositoryImpl privacySettingsRepositoryImpl) {
        return new GetPrivacySettingsByOwner(privacySettingsRepositoryImpl);
    }
}
