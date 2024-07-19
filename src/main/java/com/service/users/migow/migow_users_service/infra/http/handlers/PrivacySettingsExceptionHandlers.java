package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.privacy_settings.PrivacySettingsNotFoundException;

@ControllerAdvice
public class PrivacySettingsExceptionHandlers {
    @ExceptionHandler(PrivacySettingsNotFoundException.class)
    public ResponseEntity<ResponseErrorBody> handlerPrivacySettingsNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody("PrivacySettings settings not found", HttpStatus.NOT_FOUND.value()));
    }
}
