package com.service.users.migow.migow_users_service.main.factories.usecases.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.account_preference_settings.CreateAccountPreferenceSettingsUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.notification_settings.CreateNotificationsSettingsUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings.CreatePrivacySettingsUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.CreateUserUseCase;
import com.service.users.migow.migow_users_service.application.usecases.users.CreateUser;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserRepositoryImpl;

@Configuration
public class CreateUserFactory {
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepositoryImpl userRepository,
            CreateAccountPreferenceSettingsUseCase capsUseCase, CreatePrivacySettingsUseCase cpsUseCase,
            CreateNotificationsSettingsUseCase cnsUseCase) {
        return new CreateUser(userRepository, capsUseCase, cpsUseCase, cnsUseCase);
    }
}
