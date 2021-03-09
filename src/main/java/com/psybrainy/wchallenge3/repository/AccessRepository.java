package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import com.psybrainy.wchallenge3.repository.crud.AccessCrudRepository;
import com.psybrainy.wchallenge3.repository.entity.AccessEntity;
import com.psybrainy.wchallenge3.repository.mapper.AccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.*;


@Repository
public class AccessRepository {

    @Autowired
    AccessCrudRepository accessCrud;

    @Autowired
    AccessMapper mapper;


    public Optional<List<AccessRequest>> getByAlbunAndAccess(Long albumId, String access){

        List<AccessEntity> accessEntityList = accessCrud.findByIdAlbumAndAccess(albumId,access)
                .orElseThrow(EntityNotFoundException::new) ;

        Iterator<AccessEntity> myIterator = accessEntityList.iterator();

        Optional<List<AccessRequest>> accessRequests = Optional.of(new ArrayList<>());

        while (myIterator.hasNext()){
            accessRequests.orElse(new ArrayList<>()).add(mapper.toAccessRequest(myIterator.next()));
        }
        return accessRequests;

    }

    public AccessRequest saveAccess(AccessRequest accessRequest){
        AccessEntity accessEntity = mapper.toAccessEntity(accessRequest);
        return mapper.toAccessRequest(accessCrud.save(accessEntity));
    }

    public Optional<AccessRequest> findByIdAlbumAndUserId(Long albumId, Long userId){
        Optional<AccessEntity> accessEntity = accessCrud.findByIdAlbumAndUserId(albumId, userId);

        return Optional.of(mapper.toAccessRequest(accessEntity
                .orElseThrow(EntityNotFoundException::new)));
    }


    public Optional<AccessRequest> updatePermissionByAlbum(AccessRequest access, Long albumId, Long userId) {

        Optional<AccessRequest> accessRequest = findByIdAlbumAndUserId(albumId,userId);

        accessRequest.orElseThrow(EntityNotFoundException::new).setAccess(access.getAccess());

        saveAccess(accessRequest.orElseThrow(EntityNotFoundException::new));

        return accessRequest;
    }
}
