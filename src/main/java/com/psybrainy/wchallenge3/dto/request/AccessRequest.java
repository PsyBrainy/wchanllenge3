package com.psybrainy.wchallenge3.dto.request;

import org.springframework.stereotype.Component;

@Component
public class AccessRequest {

    private Long accessId;
    private Long albumId;
    private String albumTitle;
    private Long userId;
    private String access;

    public AccessRequest() {
    }


    public AccessRequest(Long accessId, Long albumId, String albumTitle, Long userId, String access) {
        this.accessId = accessId;
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.userId = userId;
        this.access = access;
    }

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

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
