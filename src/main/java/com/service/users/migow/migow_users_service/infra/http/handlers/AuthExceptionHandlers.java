package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandlers {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseErrorBody> handlerUsernameNotFoundException(UsernameNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.UNAUTHORIZED.value()));
    }
}
