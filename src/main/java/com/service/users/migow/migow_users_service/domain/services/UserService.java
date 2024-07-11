package com.service.users.migow.migow_users_service.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaAccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaNotificationsSettingsRepository;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaPrivacySettingsRepository;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaUserRepository;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;
import com.service.users.migow.migow_users_service.infra.http.dtos.UpdateUserDTO;
import com.service.users.migow.migow_users_service.infra.http.handlers.UserNotFounException;

@Service
public class UserService {
    private final JpaUserRepository userRepository;
    private final JpaAccountPreferenceSettingsRepository accountPreferenceSettingsRepository;
    private final JpaPrivacySettingsRepository privacySettingsRepository;
    private final JpaNotificationsSettingsRepository notificationsSettingsRepository;

    public UserService(
            JpaUserRepository userRepository,
            JpaAccountPreferenceSettingsRepository accountPreferenceSettingsRepository,
            JpaPrivacySettingsRepository privacySettingsRepository,
            JpaNotificationsSettingsRepository notificationsSettingsRepository) {
        this.userRepository = userRepository;
        this.accountPreferenceSettingsRepository = accountPreferenceSettingsRepository;
        this.privacySettingsRepository = privacySettingsRepository;
        this.notificationsSettingsRepository = notificationsSettingsRepository;
    }

    public SimpleUserDTO findUserById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFounException("User with id '" + userId + "' not found"));
        return new SimpleUserDTO(user);
    }

    public SimpleUserDTO findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFounException(String.format("User with username '%s' not found", username)));
        return new SimpleUserDTO(user);
    }

    public Page<SimpleUserDTO> findUsersByUsernamePrefix(String usernamePrefix, Pageable pageable) {
        return userRepository.findUsersByUsernamePrefix(usernamePrefix, pageable).map(user -> new SimpleUserDTO(user));
    }

    // public Page<SimpleUserDTO> findFollowerUsersByFollowedId(UUID followedId,
    // Pageable pageable) {
    // return followerService.findFollowersByFollowedId(followedId, pageable)
    // .map(follower -> new SimpleUserDTO(follower.getId().getFollowerUser()));
    // }

    public void updateUser(@PathVariable UUID userId, @RequestBody UpdateUserDTO updateUserDTO) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty())
            throw new UserNotFounException();

        User user = optionalUser.get();

        String name = updateUserDTO.getName();
        if (!name.isEmpty())
            user.setName(name);

        String email = updateUserDTO.getEmail();
        if (!email.isEmpty())
            user.setEmail(email);

        String username = updateUserDTO.getUsername();
        if (!username.isEmpty())
            user.setUsername(username);

        // TODO: save password hash
        String password = updateUserDTO.getPassword();
        if (!password.isEmpty())
            user.setPassword(password);

        String profileImageUrl = updateUserDTO.getProfileImageUrl();
        if (!profileImageUrl.isEmpty())
            user.setProfileImageUrl(profileImageUrl);

        String bgImageUrl = updateUserDTO.getBgImageUrl();
        if (!bgImageUrl.isEmpty())
            user.setBgImageUrl(bgImageUrl);

    }

    // TODO: remove
    // public Page<FollowerUserDTO> findDetailedUsers(UUID followedId, Pageable pageable) {
    //     Page<User> users = userRepository.findAll(pageable);

    //     return users.map(user -> {
    //         boolean isFollower = followerService.isFollower(user.getId(), followedId);
    //         return new FollowerUserDTO(user, isFollower);
    //     });
    // }

    public User save(User obj) {
        User user = userRepository.save(obj);

        AccountPreferenceSettings accountPreferenceSettings = new AccountPreferenceSettings();
        accountPreferenceSettings.setOwner(user);
        accountPreferenceSettings.setTheme(0);
        accountPreferenceSettings.setSoundEffects(true);
        accountPreferenceSettings.setOnlineUsersLimit(0);
        accountPreferenceSettingsRepository.save(accountPreferenceSettings);

        PrivacySettings privacySettings = new PrivacySettings();
        privacySettings.setOwner(user);
        privacySettings.setImageProfileVisibility(0);
        privacySettings.setNameVisibility(0);
        privacySettings.setBioVisibility(0);
        privacySettings.setFollowersVisibility(0);
        privacySettings.setActivityVisibility(0);
        privacySettings.setOnlineStatusVisibility(0);
        privacySettings.setMessageReadConfirmationVisibility(0);
        privacySettingsRepository.save(privacySettings);

        NotificationSettings notificationsSettings = new NotificationSettings();
        notificationsSettings.setOwner(user);
        notificationsSettings.setWhenFollowersPostSomething(true);
        notificationsSettings.setWhenFollowersCommentSomethig(true);
        notificationsSettings.setWhenFollowersReactSomething(true);
        notificationsSettings.setWhenFollowersReplaySomething(true);
        notificationsSettings.setWhenFollowersMentionMe(true);
        notificationsSettingsRepository.save(notificationsSettings);

        return user;
    }

    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login).orElseThrow(() -> new UserNotFounException());
    }
}
