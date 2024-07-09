package com.service.users.migow.migow_users_service.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaPrivacySettingsRepository;
import com.service.users.migow.migow_users_service.infra.http.handlers.PrivacySettingsNotFoundException;

@Service
public class PrivacySettingsService {
    @Autowired
    JpaPrivacySettingsRepository repository;

    public PrivacySettings findByOwner(User user) {
        return repository.findByOwner(user).orElseThrow(() -> new PrivacySettingsNotFoundException());
    }

    public PrivacySettings save(PrivacySettings obj) {
        return repository.save(obj);

    }
}
