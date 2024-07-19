package com.service.users.migow.migow_users_service.domain.exceptions.friendships;

public class ExistingFriendshipException extends RuntimeException {
    public ExistingFriendshipException(String message) {
        super(message);
    }

    public ExistingFriendshipException() {
        super("There is already friendship between the provided users");
    }
}
