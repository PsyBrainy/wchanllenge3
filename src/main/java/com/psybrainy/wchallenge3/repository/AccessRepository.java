package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class AccessRepository {

    @Autowired
    DatabaseRepository repo;

    public AccessRequest updatePermissionByAlbum(AccessRequest access, Long albumId, Long userId) {

        Optional<AccessRequest> accessRequest = repo.findByIdAlbumAndUserId(albumId,userId);

        Optional<AccessRequest> accessSave = Optional
                .of(new AccessRequest(accessRequest
                        .get().getAccessId(), accessRequest.get().getAlbumId(),accessRequest.get().getAlbumTitle() ,
                        accessRequest.get().getUserId(), access.getAccess()));

        access = accessSave.get();

        return repo.saveAccess(access);
    }
}
