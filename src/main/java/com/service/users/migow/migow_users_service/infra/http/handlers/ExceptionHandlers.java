package com.service.users.migow.migow_users_service.infra.http.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(UserNotFounException.class)
    public ResponseEntity<Map<String, Object>> handlerUserNotFoundException(UserNotFounException e) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", e.getMessage());
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(AccountPreferenceSettingsNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerAccountPreferenceSettingsNotFoundException() {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", "Account preference settings not found");
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(PrivacySettingsNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerPrivacySettingsNotFoundException() {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", "PrivacySettings settings not found");
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(NotificationsSettingsNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNotificationsSettingsNotFoundException() {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", "Notifications settings not found");
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        if (ex.getRequiredType() == UUID.class) {
            errorDetails.put("error", "Invalid UUID format");
        } else {
            errorDetails.put("error", "Invalid parameter type");
        }
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("error", ex.getMessage());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

}
