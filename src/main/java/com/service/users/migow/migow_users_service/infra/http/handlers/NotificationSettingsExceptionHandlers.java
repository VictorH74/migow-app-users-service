package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.notification_settings.NotificationsSettingsNotFoundException;

@ControllerAdvice
public class NotificationSettingsExceptionHandlers {
    @ExceptionHandler(NotificationsSettingsNotFoundException.class)
    public ResponseEntity<ResponseErrorBody> handlerNotificationsSettingsNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody("Notifications settings not found", HttpStatus.NOT_FOUND.value()));
    }
}
