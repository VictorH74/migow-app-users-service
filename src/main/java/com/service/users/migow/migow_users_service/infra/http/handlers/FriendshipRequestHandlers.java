package com.service.users.migow.migow_users_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.users.migow.migow_users_service.domain.exceptions.friendship_requests.NotFoundFriendshipRequestException;

@ControllerAdvice
public class FriendshipRequestHandlers {
    @ExceptionHandler(NotFoundFriendshipRequestException.class)
    public ResponseEntity<ResponseErrorBody> handlerNotFoundFriendshipException(NotFoundFriendshipRequestException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

}
