package com.psybrainy.wchallenge3.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "album")
public class AlbumEntity {

    @Id
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "ouner_id")
    private Long ownerId;

    @Column(name = "title")
    private String title;

    private List<AccessEntity> access;



    public List<AccessEntity> getAccess() {
        return access;
    }

    public void setAccess(List<AccessEntity> access) {
        this.access = access;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
