package com.service.users.migow.migow_users_service.application.interfaces.usecases.account_preference_settings;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;

public interface CreateAccountPreferenceSettingsUseCase {
    AccountPreferenceSettings execute(AccountPreferenceSettings obj);
}
