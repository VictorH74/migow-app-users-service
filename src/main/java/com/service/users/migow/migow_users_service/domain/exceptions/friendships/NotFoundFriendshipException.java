package com.service.users.migow.migow_users_service.domain.exceptions.friendships;

public class NotFoundFriendshipException extends RuntimeException {
    public NotFoundFriendshipException(String message) {
        super(message);
    }

    public NotFoundFriendshipException() {
        super("Friendship with the given user ids not found!");
    }

}
