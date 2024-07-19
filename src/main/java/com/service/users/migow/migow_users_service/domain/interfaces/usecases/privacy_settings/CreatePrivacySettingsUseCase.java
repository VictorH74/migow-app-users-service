package com.service.users.migow.migow_users_service.domain.interfaces.usecases.privacy_settings;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;

public interface CreatePrivacySettingsUseCase {
    PrivacySettings execute(PrivacySettings obj);
}
