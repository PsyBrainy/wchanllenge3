package com.psybrainy.wchallenge3.repository;

import com.psybrainy.wchallenge3.dto.request.AccessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class AccessRepository {

    @Autowired
    DatabaseRepository repo;

    public AccessRequest updatePermissionByAlbum(Long albumId, Long userId) {

        Optional<AccessRequest> accessRequest = repo.findByIdAlbumAndUserId(albumId,userId);

        AccessRequest accessRequest1 = accessRequest.get();

        repo.saveAccess(accessRequest1);

        return null;
    }
}
