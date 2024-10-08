package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.users.CreateUserDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.enums.VisibilityEnum;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.account_preference_settings.CreateAccountPreferenceSettingsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.notification_settings.CreateNotificationsSettingsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings.CreatePrivacySettingsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.CreateUserUseCase;

import jakarta.transaction.Transactional;

@Component
public class CreateUser implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final CreateAccountPreferenceSettingsUseCase cAPSettingsUseCase;
    private final CreatePrivacySettingsUseCase cPSettingsUseCase;
    private final CreateNotificationsSettingsUseCase cNSettingsUseCase;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${kafka.topic.userCreated}")
    private String userCreatedTopic;

    public CreateUser(UserRepository userRepository,
            CreateAccountPreferenceSettingsUseCase cAPSettingsUseCase,
            CreatePrivacySettingsUseCase cPSettingsUseCase,
            CreateNotificationsSettingsUseCase cNSettingsUseCase,
            KafkaTemplate<String, Object> kafkaTemplate,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.cAPSettingsUseCase = cAPSettingsUseCase;
        this.cPSettingsUseCase = cPSettingsUseCase;
        this.cNSettingsUseCase = cNSettingsUseCase;
        this.kafkaTemplate = kafkaTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public SimpleUserDTO execute(CreateUserDTO obj) {
        if (obj.getId() == null) {
            obj.setId(UUID.randomUUID());
        }

        User user = new User();
        user.setId(obj.getId());
        user.setName(obj.getName());
        user.setUsername(obj.getUsername());
        user.setPassword(passwordEncoder.encode(obj.getPassword()));
        user.setProfileImageUrl(obj.getProfileImageUrl());
        user.setBgImageUrl(obj.getBgImageUrl());
        user.setEmail(obj.getEmail());

        User createdUser = userRepository.createUpdateUser(user);

        AccountPreferenceSettings accountPreferenceSettings = new AccountPreferenceSettings();
        accountPreferenceSettings.setOwner(createdUser);
        accountPreferenceSettings.setTheme(1);
        accountPreferenceSettings.setSoundEffects(true);
        accountPreferenceSettings.setOnlineUsersLimit(1);
        cAPSettingsUseCase.execute(accountPreferenceSettings);

        PrivacySettings privacySettings = new PrivacySettings();
        privacySettings.setOwner(createdUser);
        privacySettings.setImageProfileVisibility(VisibilityEnum.ALL.getCode());
        privacySettings.setNameVisibility(VisibilityEnum.ALL.getCode());
        privacySettings.setBioVisibility(VisibilityEnum.ALL.getCode());
        privacySettings.setFriendshipsVisibility(VisibilityEnum.ALL.getCode());
        privacySettings.setActivityVisibility(VisibilityEnum.ALL.getCode());
        privacySettings.setOnlineStatusVisibility(VisibilityEnum.ALL.getCode());
        privacySettings.setMessageReadConfirmationVisibility(VisibilityEnum.ALL.getCode());
        cPSettingsUseCase.execute(privacySettings);

        NotificationSettings notificationsSettings = new NotificationSettings();
        notificationsSettings.setOwner(createdUser);
        notificationsSettings.setWhenFriendsPostSomething(true);
        notificationsSettings.setWhenFriendsCommentSomethig(true);
        notificationsSettings.setWhenFriendsReactSomething(true);
        notificationsSettings.setWhenFriendsReplySomething(true);
        notificationsSettings.setWhenFriendsMentionMe(true);
        cNSettingsUseCase.execute(notificationsSettings);

        kafkaTemplate.send(userCreatedTopic, createdUser);

        return new SimpleUserDTO(createdUser);
    }

}
