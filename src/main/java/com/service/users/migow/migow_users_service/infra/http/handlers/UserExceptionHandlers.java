package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.user.UserNotFounException;

@ControllerAdvice
public class UserExceptionHandlers {
    @ExceptionHandler(UserNotFounException.class)
    public ResponseEntity<ResponseErrorBody> handlerUserNotFoundException(UserNotFounException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
