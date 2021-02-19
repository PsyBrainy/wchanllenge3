package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.crud.AccessCrudRepository;
import com.psybrainy.wchallenge3.repository.crud.AlbumCrudRepository;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import com.psybrainy.wchallenge3.repository.entity.AlbumEntity;
import com.psybrainy.wchallenge3.repository.mapper.AccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DatabaseRepository {

    @Autowired
    AlbumCrudRepository albumCrud;

    @Autowired
    AccessCrudRepository accessCrud;

    @Autowired
    AccessMapper mapper;


    public AlbumEntity saveAlbum(AlbumEntity albumEntity){
        return albumCrud.save(albumEntity);
    }

    public Optional<AlbumEntity> findDBAlbumById(Long albumId){
        return albumCrud.findById(albumId);
    }

    public AccessRequest saveAccess(AccessRequest accessRequest){
        AccessEntity accessEntity = mapper.toAccessEntity(accessRequest);
        return mapper.toAccessRequest(accessCrud.save(accessEntity));
    }

    public Optional<AccessRequest> findByIdAlbumAndUserId(Long albumId, Long userId){
        Optional<AccessEntity> accessEntity = null;
        try {
            accessEntity = Optional.ofNullable(mapper.toAccessEntity(accessCrud.findByIdAlbumAndUserId(albumId, userId)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new)));
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }

        return Optional.of(mapper.toAccessRequest(accessEntity.get()));
    }

}
