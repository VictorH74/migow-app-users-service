package com.service.users.migow.migow_users_service.domain.enums;

public enum FriendshipStatusEnum {
    IS_FRIEND(1),
    IS_NOT_FRIEND(2),
    PENDING(3);

    private final int code;

    FriendshipStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FriendshipStatusEnum fromCode(int code) {
        for (FriendshipStatusEnum friendshipStatusEnum : FriendshipStatusEnum.values()) {
            if (friendshipStatusEnum.getCode() == code) {
                return friendshipStatusEnum;
            }
        }
        throw new IllegalArgumentException("Invalid code for FriendshipStatusEnum: " + code);
    }
}
