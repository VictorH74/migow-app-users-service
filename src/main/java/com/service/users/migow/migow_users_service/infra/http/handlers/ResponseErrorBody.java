package com.service.users.migow.migow_users_service.infra.http.handlers;

import java.io.Serializable;

public class ResponseErrorBody implements Serializable {
    private final String message;
    private final int status;

    public ResponseErrorBody(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

}
