package com.psybrainy.wchallenge3.repository.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "album")
public class AlbumEntity {

    @Id
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "albumEntity")
    private List<AccessEntity> access;

    public AlbumEntity() {
    }

    public AlbumEntity(Long albumId, Long ownerId, String title) {
        this.albumId = albumId;
        this.ownerId = ownerId;
        this.title = title;
    }

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
