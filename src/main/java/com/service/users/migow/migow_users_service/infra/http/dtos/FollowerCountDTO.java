package com.service.users.migow.migow_users_service.infra.http.dtos;

public class FollowerCountDTO {
    private Long count;

    public FollowerCountDTO(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
