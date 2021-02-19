package com.psybrainy.wchallenge3.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_access")
public class AccessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccess;

    @Column(name = "album_id")
    private Long idAlbum;

    @Column(name = "album_title")
    private String albumTitle;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "access")
    private String access;

    public AccessEntity() {
    }

    public AccessEntity(Long idAlbum,String albumTitle , Long userId, String access) {
        this.idAlbum = idAlbum;
        this.userId = userId;
        this.access = access;
        this.albumTitle = albumTitle;
    }

    public Long getIdAccess() {
        return idAccess;
    }

    public void setIdAccess(Long idAccess) {
        this.idAccess = idAccess;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Long getUserId() {
        return this.userId;
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

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
}
