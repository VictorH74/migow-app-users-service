package com.service.users.migow.migow_users_service.application.interfaces.usecases.account_preference_settings;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface GetAccountPreferenceSettingsByOwnerUseCase {
    AccountPreferenceSettings execute(User user);
}
