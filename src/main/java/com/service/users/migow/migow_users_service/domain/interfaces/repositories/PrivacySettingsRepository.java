package com.service.users.migow.migow_users_service.domain.interfaces.repositories;

import java.util.Optional;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface PrivacySettingsRepository {
    PrivacySettings createPrivacySettings(PrivacySettings obj);

    Optional<PrivacySettings> getPrivacySettingsByOwner(User user);
}
