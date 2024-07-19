package com.service.users.migow.migow_users_service.domain.exceptions.user;

public class UserNotFounException extends RuntimeException {
    public UserNotFounException() {
        super("User not found");
    }

    public UserNotFounException(String message) {
        super(message);
    }

}
