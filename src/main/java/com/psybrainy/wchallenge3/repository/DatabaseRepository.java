package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.repository.crud.AccessCrudRepository;
import com.psybrainy.wchallenge3.repository.crud.AlbumCrudRepository;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import com.psybrainy.wchallenge3.repository.entity.AlbumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DatabaseRepository {

    @Autowired
    AlbumCrudRepository albumCrud;

    @Autowired
    AccessCrudRepository accessCrud;

    public AlbumEntity saveAlbum(AlbumEntity albumEntity){
        return albumCrud.save(albumEntity);
    }

    public Optional<AlbumEntity> findDBAlbumById(Long albumId){
        return albumCrud.findById(albumId);
    }

    public AccessEntity saveAccess(AccessEntity accessEntity){
        return accessCrud.save(accessEntity);
    }


}
