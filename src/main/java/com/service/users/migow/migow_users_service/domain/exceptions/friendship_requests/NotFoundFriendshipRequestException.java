package com.service.users.migow.migow_users_service.domain.exceptions.friendship_requests;

public class NotFoundFriendshipRequestException extends RuntimeException {
    public NotFoundFriendshipRequestException(String message) {
        super(message);
    }

    public NotFoundFriendshipRequestException() {
        super("FriendshipRequest with the given user ids not found!");
    }

}
