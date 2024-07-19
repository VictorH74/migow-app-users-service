package com.service.users.migow.migow_users_service.domain.interfaces.repositories;

import java.util.Optional;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface AccountPreferenceSettingsRepository {
    AccountPreferenceSettings createAccountPreferenceSettings(AccountPreferenceSettings obj);

    Optional<AccountPreferenceSettings> getAccountPreferenceSettingsByOwner(User user);
}
