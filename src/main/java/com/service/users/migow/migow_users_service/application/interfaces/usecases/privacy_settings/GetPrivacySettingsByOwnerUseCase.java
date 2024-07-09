package com.service.users.migow.migow_users_service.application.interfaces.usecases.privacy_settings;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface GetPrivacySettingsByOwnerUseCase {
    PrivacySettings execute(User user);
}
