package com.service.users.migow.migow_users_service.domain.enums;

public enum AccountPreferenceThemeEnum {
    DEVICE(1),
    DARK(2),
    LIGHT(3);

    private final int code;

    private AccountPreferenceThemeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static AccountPreferenceThemeEnum valueOf(int code) {
        for (AccountPreferenceThemeEnum value : AccountPreferenceThemeEnum.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid AccountPreferenceThemeEnum code!");
    }
}
