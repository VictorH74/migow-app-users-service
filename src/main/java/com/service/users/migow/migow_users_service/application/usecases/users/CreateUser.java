package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings.CreateAccountPreferenceSettingsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings.CreateNotificationsSettingsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings.CreatePrivacySettingsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.CreateUserUseCase;

@Component
public class CreateUser implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final CreateAccountPreferenceSettingsUseCase cAPSettingsUseCase;
    private final CreatePrivacySettingsUseCase cPSettingsUseCase;
    private final CreateNotificationsSettingsUseCase cNSettingsUseCase;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreateUser(UserRepository userRepository, CreateAccountPreferenceSettingsUseCase cAPSettingsUseCase,
            CreatePrivacySettingsUseCase cPSettingsUseCase, CreateNotificationsSettingsUseCase cNSettingsUseCase) {
        this.userRepository = userRepository;
        this.cAPSettingsUseCase = cAPSettingsUseCase;
        this.cPSettingsUseCase = cPSettingsUseCase;
        this.cNSettingsUseCase = cNSettingsUseCase;
    }

    @Override
    public User execute(User obj) {
        if (obj.getId().toString().isEmpty())
            obj.setId(UUID.randomUUID());

        obj.setPassword(passwordEncoder.encode(obj.getPassword()));

        User user = userRepository.createUpdateUser(obj);

        AccountPreferenceSettings accountPreferenceSettings = new AccountPreferenceSettings();
        accountPreferenceSettings.setOwner(user);
        accountPreferenceSettings.setTheme(0);
        accountPreferenceSettings.setSoundEffects(true);
        accountPreferenceSettings.setOnlineUsersLimit(0);
        cAPSettingsUseCase.execute(accountPreferenceSettings);

        PrivacySettings privacySettings = new PrivacySettings();
        privacySettings.setOwner(user);
        privacySettings.setImageProfileVisibility(0);
        privacySettings.setNameVisibility(0);
        privacySettings.setBioVisibility(0);
        privacySettings.setFollowersVisibility(0);
        privacySettings.setActivityVisibility(0);
        privacySettings.setOnlineStatusVisibility(0);
        privacySettings.setMessageReadConfirmationVisibility(0);
        cPSettingsUseCase.execute(privacySettings);

        NotificationSettings notificationsSettings = new NotificationSettings();
        notificationsSettings.setOwner(user);
        notificationsSettings.setWhenFollowersPostSomething(true);
        notificationsSettings.setWhenFollowersCommentSomethig(true);
        notificationsSettings.setWhenFollowersReactSomething(true);
        notificationsSettings.setWhenFollowersReplaySomething(true);
        notificationsSettings.setWhenFollowersMentionMe(true);
        cNSettingsUseCase.execute(notificationsSettings);

        return user;
    }

}
