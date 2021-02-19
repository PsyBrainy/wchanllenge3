package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.crud.AccessCrudRepository;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import com.psybrainy.wchallenge3.repository.mapper.AccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class AccessRepository {

    @Autowired
    AccessCrudRepository accessCrud;

    @Autowired
    AccessMapper mapper;


    public AccessRequest saveAccess(AccessRequest accessRequest){
        AccessEntity accessEntity = mapper.toAccessEntity(accessRequest);
        return mapper.toAccessRequest(accessCrud.save(accessEntity));
    }

    public Optional<AccessRequest> findByIdAlbumAndUserId(Long albumId, Long userId){
        Optional<AccessEntity> accessEntity = accessCrud.findByIdAlbumAndUserId(albumId, userId);

        return Optional.of(mapper.toAccessRequest(accessEntity.get()));
    }


    public AccessRequest updatePermissionByAlbum(AccessRequest access, Long albumId, Long userId) {

        Optional<AccessRequest> accessRequest = findByIdAlbumAndUserId(albumId,userId);

        Optional<AccessRequest> accessSave = Optional
                .of(new AccessRequest(accessRequest
                        .get().getAccessId(), accessRequest.get().getAlbumId(),accessRequest.get()
                        .getAlbumTitle() , accessRequest.get().getUserId(), access.getAccess()));

        access = accessSave.get();

        return saveAccess(access);
    }
}
