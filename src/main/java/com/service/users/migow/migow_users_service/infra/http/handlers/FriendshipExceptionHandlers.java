package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.friendships.ExistingFriendshipException;
import com.service.users.migow.migow_users_service.domain.exceptions.friendships.NotFoundFriendshipException;

@ControllerAdvice
public class FriendshipExceptionHandlers {
    @ExceptionHandler(ExistingFriendshipException.class)
    public ResponseEntity<ResponseErrorBody> handlerExistingFriendshipException(ExistingFriendshipException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(NotFoundFriendshipException.class)
    public ResponseEntity<ResponseErrorBody> handlerNotFoundFriendshipException(NotFoundFriendshipException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
