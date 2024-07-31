package com.service.users.migow.migow_users_service.infra.http.handlers;

import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.service.users.migow.migow_users_service.domain.exceptions.friendships.ExistingFriendshipException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseErrorBody> handleTypeMismatch(MissingServletRequestParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseErrorBody(
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseErrorBody> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseErrorBody(
                        ex.getRequiredType() == UUID.class ? "Invalid UUID format" : "Invalid parameter type",
                        HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseErrorBody> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(ExistingFriendshipException.class)
    public ResponseEntity<ResponseErrorBody> handleIllegalArgumentException(ExistingFriendshipException ex) {
        return ResponseEntity.status(HttpStatus.IM_USED)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.IM_USED.value()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseErrorBody> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "Data integrity violation";
        Throwable rootCause = ex.getRootCause();

        if (rootCause instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) rootCause;
            if (constraintViolationException.getMessage().contains("UK_USERNAME")) {
                message = "Username must be unique";
            } else if (constraintViolationException.getMessage().contains("UK_EMAIL")) {
                message = "Email must be unique";
            }
        }

        ResponseErrorBody responseErrorBody = new ResponseErrorBody(message, HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseErrorBody);
    }

}
