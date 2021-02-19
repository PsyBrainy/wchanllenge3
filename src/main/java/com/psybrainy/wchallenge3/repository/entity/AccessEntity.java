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

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "access")
    private String access;

    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    @ManyToOne
    private AlbumEntity albumEntity;

    public AccessEntity() {
    }



    public AccessEntity(Long idAlbum, Long userId, String access, AlbumEntity albumEntity) {
        this.idAlbum = idAlbum;
        this.userId = userId;
        this.access = access;
        this.albumEntity = albumEntity;
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

    public AlbumEntity getAlbumEntity() {
        return albumEntity;
    }

    public void setAlbumEntity(AlbumEntity albumEntity) {
        this.albumEntity = albumEntity;
    }
}
