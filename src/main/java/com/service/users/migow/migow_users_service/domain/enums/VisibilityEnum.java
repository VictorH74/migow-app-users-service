package com.service.users.migow.migow_users_service.domain.enums;

public enum VisibilityEnum {
    ALL(1),
    FRIENDS(2),
    NOBODY(3);

    private final int code;

    private VisibilityEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static VisibilityEnum valueOf(int code) {
        for (VisibilityEnum value : VisibilityEnum.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid VisibilityEnum code!");
    }

}
