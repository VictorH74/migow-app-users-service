package com.service.users.migow.migow_users_service.domain.enums;

public enum AccountPreferenceOnlineUsersLimitEnum {
    FIRSTSIX(1),
    FULLHEIGHT(2);

    private final int code;

    private AccountPreferenceOnlineUsersLimitEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static AccountPreferenceOnlineUsersLimitEnum valueOf(int code) {
        for (AccountPreferenceOnlineUsersLimitEnum value : AccountPreferenceOnlineUsersLimitEnum.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid AccountPreferenceOnlineUsersLimitEnum code!");
    }
}
