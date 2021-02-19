package com.psybrainy.wchallenge3.dto.request;

import org.springframework.stereotype.Component;

@Component
public class AccessRequest {

    private Long userId;
    private String access;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
