package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.friendships.ExistingFriendshipException;

@ControllerAdvice
public class FriendshipExceptionHandlers {
    @ExceptionHandler(ExistingFriendshipException.class)
    public ResponseEntity<ResponseErrorBody> handlerExistingFriendshipException(ExistingFriendshipException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.CONFLICT.value()));
    }
}
