package com.service.users.migow.migow_users_service.infra.db.repositories.implementations;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.PrivacySettingsRepository;
import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaPrivacySettingsRepository;

@Repository
public class PrivacySettingsRepositoryImpl implements PrivacySettingsRepository {
    private final JpaPrivacySettingsRepository jpaPrivacySettingsRepository;

    public PrivacySettingsRepositoryImpl(JpaPrivacySettingsRepository jpaPrivacySettingsRepository) {
        this.jpaPrivacySettingsRepository = jpaPrivacySettingsRepository;
    }

    @Override
    public PrivacySettings createPrivacySettings(PrivacySettings obj) {
        return jpaPrivacySettingsRepository.save(obj);
    }

    @Override
    public Optional<PrivacySettings> getPrivacySettingsByOwner(User user) {
        return jpaPrivacySettingsRepository.findByOwner(user);
    }

}
