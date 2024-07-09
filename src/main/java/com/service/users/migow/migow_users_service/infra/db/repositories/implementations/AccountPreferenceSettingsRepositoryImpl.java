package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.AccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaAccountPreferenceSettingsRepository;

@Repository
public class AccountPreferenceSettingsRepositoryImpl implements AccountPreferenceSettingsRepository {
    private final JpaAccountPreferenceSettingsRepository jpaAccountPreferenceSettingsRepository;

    public AccountPreferenceSettingsRepositoryImpl(
            JpaAccountPreferenceSettingsRepository jpaAccountPreferenceSettingsRepository) {
        this.jpaAccountPreferenceSettingsRepository = jpaAccountPreferenceSettingsRepository;
    }

    @Override
    public AccountPreferenceSettings createAccountPreferenceSettings(AccountPreferenceSettings obj) {
        return jpaAccountPreferenceSettingsRepository.save(obj);
    }

    @Override
    public Optional<AccountPreferenceSettings> getAccountPreferenceSettingsByOwner(User user) {
        return jpaAccountPreferenceSettingsRepository.findByOwner(user);
    }

}
