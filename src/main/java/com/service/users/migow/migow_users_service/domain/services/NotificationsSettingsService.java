package com.service.users.migow.migow_users_service.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaNotificationsSettingsRepository;
import com.service.users.migow.migow_users_service.infra.http.handlers.NotificationsSettingsNotFoundException;

@Service
public class NotificationsSettingsService {
    @Autowired
    JpaNotificationsSettingsRepository repository;

    public NotificationSettings findByOwner(User user) {
        return repository.findByOwner(user).orElseThrow(() -> new NotificationsSettingsNotFoundException());
    }

    public NotificationSettings save(NotificationSettings obj) {
        return repository.save(obj);

    }
}
