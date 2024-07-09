package com.service.users.migow.migow_users_service.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.users.migow.migow_users_service.domain.entities.AccountPreferenceSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaAccountPreferenceSettingsRepository;
import com.service.users.migow.migow_users_service.infra.http.handlers.AccountPreferenceSettingsNotFoundException;

@Service
public class AccountPreferenceSettingsService {
    @Autowired
    JpaAccountPreferenceSettingsRepository repository;

    public AccountPreferenceSettings findByOwner(User user) {
        return repository.findByOwner(user).orElseThrow(() -> new AccountPreferenceSettingsNotFoundException());
    }

    public AccountPreferenceSettings save(AccountPreferenceSettings obj) {
        return repository.save(obj);

    }
}
