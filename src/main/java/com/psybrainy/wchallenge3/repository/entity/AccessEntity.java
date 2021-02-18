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

    private AlbumEntity albumEntity;
}
