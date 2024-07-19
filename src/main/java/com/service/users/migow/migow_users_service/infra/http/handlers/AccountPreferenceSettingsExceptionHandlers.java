package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.account_preference_settings.AccountPreferenceSettingsNotFoundException;

@ControllerAdvice
public class AccountPreferenceSettingsExceptionHandlers {
    @ExceptionHandler(AccountPreferenceSettingsNotFoundException.class)
    public ResponseEntity<ResponseErrorBody> handlerAccountPreferenceSettingsNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody("Account preference settings not found", HttpStatus.NOT_FOUND.value()));
    }
}
