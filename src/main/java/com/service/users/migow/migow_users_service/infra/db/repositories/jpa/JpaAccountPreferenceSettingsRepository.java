package com.service.users.migow.migow_users_service.infra.db.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;

public interface JpaAccountPreferenceSettingsRepository extends JpaRepository<AccountPreferenceSettings, Long> {

    public Optional<AccountPreferenceSettings> findByOwner(User user);

}
