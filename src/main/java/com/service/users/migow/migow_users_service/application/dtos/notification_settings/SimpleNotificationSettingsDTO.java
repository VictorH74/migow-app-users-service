package com.service.users.migow.migow_users_service.application.dtos.notification_settings;

import com.service.users.migow.migow_users_service.domain.entities.NotificationSettings;

import lombok.Getter;

@Getter
public class SimpleNotificationSettingsDTO {
    private final Long id;
    private final Boolean whenFriendsPostSomething;
    private final Boolean whenFriendsCommentSomethig;
    private final Boolean whenFriendsReactSomething;
    private final Boolean whenFriendsReplySomething;
    private final Boolean whenFriendsMentionMe;

    public SimpleNotificationSettingsDTO(NotificationSettings nSettings) {
        this.id = nSettings.getId();
        this.whenFriendsPostSomething = nSettings.getWhenFriendsPostSomething();
        this.whenFriendsCommentSomethig = nSettings.getWhenFriendsCommentSomethig();
        this.whenFriendsReactSomething = nSettings.getWhenFriendsReactSomething();
        this.whenFriendsReplySomething = nSettings.getWhenFriendsReplySomething();
        this.whenFriendsMentionMe = nSettings.getWhenFriendsMentionMe();
    }

}
